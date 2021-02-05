/*
 * Compare the four numerical differentiation methods, forward difference, backward difference, lagrange basis and undetermined coefficients. 
 *
 * CSC 2262 Numerical Differentiation Program Findings
 *
 * @author Luke Higginbotham 899568628
 * @since 11/1/2020 
 */
package numericaldifferentiation;

public class NumericalDifferentiation 
{
    //Some comments are what I used to test if my methods where working correctly
    public static void main(String[] args) 
    {
        //int x = 2;
        double x = 2.0/3 * Math.PI;
        //double h[] = {0.2, 0.1, 0.05, 0.025, 0.0125};
        double h[] = {0.1, 0.05, 0.025, 0.0125, 0.00625};
        System.out.println("h\tFDF\t\t\tBDF\t\t\tLB\t\t\tUC");
        for(int i = 0; i < h.length; i++)
        {
            System.out.printf(h[i] + "\t");
            System.out.printf(forwardDifference(h[i], x) + "\t");
            System.out.printf(backwardDifference(h[i], x) + "\t");
            System.out.printf(lagrangeBasis(h[i], x) + "\t");
            System.out.printf(undeterminedCoefficients(h[i], x) + "\t");
            System.out.println();
        }
    }
    
    //Forward Difference Method
    public static double forwardDifference(double h, double x)
    {
        //double calculate = (Math.pow(1+Math.pow(x+h, 2), -1) - Math.pow(1+Math.pow(x, 2), -1)) / h;
        double calculate = (Math.sin(x+h) - Math.sin(x)) / h;
        return calculate;
    }
    //Backward Difference Method
    public static double backwardDifference(double h, double x)
    {
        //double calculate = (Math.pow(1+Math.pow(x, 2), -1) - Math.pow(1+Math.pow(x-h, 2), -1)) / h;
        double calculate = (Math.sin(x) - Math.sin(x-h)) / h;
        return calculate;
    }
    //Lagrange Basis Method
    public static double lagrangeBasis(double h, double x)
    {
        //double calculate = (Math.pow(1+Math.pow(x+h, 2), -1) - Math.pow(1+Math.pow(x-h, 2), -1)) / (2*h);
        double calculate = ((Math.sin(x+h) - Math.sin(x-h)) / (2*h));
        return calculate;
    }
    //Undetermined Coefficients Method
    public static double undeterminedCoefficients(double h, double x)
    {
        //double calculate = (Math.pow(1+Math.pow(x+h, 2), -1) - 2*Math.pow(1+Math.pow(x, 2), -1) + Math.pow(1+Math.pow(x-h, 2), -1)) / Math.pow(h,2);
        double calculate = (Math.sin(x+h) - 2*Math.sin(x) + Math.sin(x-h)) / Math.pow(h, 2);
        return calculate;
    }
}
