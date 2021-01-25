import java.util.*;
public class Disasters {
    public void selectIssue()
    {
        int chance = 0 + (int)(Math.random() * ((100 - 0) + 1));
        if(chance <= 25)
        {
            System.out.println("Disaster 1");
        }else if(chance > 25)
        {
            System.out.println("No Disaster");
        }
    }
    public void pipeLeak()
    {
        
    }
}