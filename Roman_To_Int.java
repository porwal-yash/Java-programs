import java.util.*;
class Roman_To_Int
{
public int value(char c)
{
    switch(c)
    {
        case 'M':
            return 1000;
        case 'D':
            return 500;
        case 'C':
            return 100;
        case 'L':
            return 50;
        case 'X':
            return 10;
        case 'V':
            return 5;
        default:
            return 1;
    }
}
public int romanToInt(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if((i+1)<s.length())
            {
                if(value(s.charAt(i))>=value(s.charAt(i+1)))
                {
                    sum+=value(s.charAt(i));
                }
                else
                {
                    sum=sum+value(s.charAt(i+1))-value(s.charAt(i));
                    i++;
                }
            }
            else if((i+1)==s.length())
                sum+=value(s.charAt(i));
        }
        return sum;
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    Roman_To_Int obj=new Roman_To_Int();
    System.out.println(obj.romanToInt(s));
}
}