package example;

public class QuickSort implements Sorter{
    private int[] a;
    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort(){
        qsort(0, a.length-1);
    }
    private void qsort(int l,int r) {
        int mid=a[(l+r)/2];//中间数
        int i=l,j=r;
        do{
            while(a[i]<mid) i++;//查找左半部分比中间数大的数
            while(a[j]>mid) j--;//查找右半部分比中间数小的数
            if(i<=j)//如果有一组不满足排序条件（左小右大）的数
            {
                swap(i,j);//交换
                i++;
                j--;
            }
        }while(i<=j);//这里注意要有=
        if(l<j) qsort(l,j);//递归搜索左半部分
        if(i<r) qsort(i,r);//递归搜索右半部分
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}