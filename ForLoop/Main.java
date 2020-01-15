class DiamondShape{
    public static void main(String[] args) {
        boolean isReverse = false;
        for(int x=1;x>0;x =(isReverse)?x-2:x+2){
            for(int i=(19-x)/2;i>0;i--)
                System.out.print(" ");
            for(int i=x;i>0;i--)
                System.out.print("*");
            if(x==19)
                isReverse = true;
            System.out.println();
        }
    }
}
class NumbersList{
    public static void main(String[] args) {
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++)
                printNumber(i*j);
            System.out.println();
        }
    }

    private static void printNumber(int i) {
        System.out.print(((i+"").length()<2)?" "+i+" ":i+" ");
    }
}