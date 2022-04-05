package Bridge;

public class WindowsImp extends Implementor {

    public void doPaint(Matrix m){
        System.out.println("调用Linux系统的绘制函数绘制像素矩阵");
    }
}
