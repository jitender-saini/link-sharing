public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main obj = new Main();
        obj.funt(obj.i,obj.a);
        System.out.println(i);
        for(int i:obj.a){
            System.out.println(i);
        }
        obj.fun(8);

    }

    static int i =0;
    int a[]={1,2,3};

    public static void funt(int i, int a[]){
        i++;
        a[0]=99;
        //a={5,6,7};
    }
    public void fun(int i){
        System.out.println("a");
    }

}
