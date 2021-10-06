package example;

public class SelectSorter implements Sorter{
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
        selectSort();
    }
    
    @Override
    public String getPlan() {
        return this.plan;
    }
    public void selectSort() {
        for (int i = 0, ln = a.length; i < ln - 1; i++) {
            int min = i;
            for (int j = min + 1; j < ln; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(min,i);
            }
        }
    }
}
