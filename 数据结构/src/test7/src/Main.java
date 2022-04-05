public class Main {

    public static void main(String[] args) {
	// write your code here
        CustomMatrix customMatrix=new CustomMatrix();
        System.out.println("请输入矩阵A");
        customMatrix.setA();
        System.out.println("请输入矩阵B");
        customMatrix.setB();
        System.out.println("转置矩阵A");
        customMatrix.changePositionA();
        System.out.println("矩阵A+B");
        customMatrix.add();
        System.out.println("矩阵AxB");
        customMatrix.multiple();
    }
}
