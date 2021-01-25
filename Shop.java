import java.util.*;
import java.io.*;
public class Shop{
    HashMap<String,Integer> levels = new HashMap<String,Integer>();
    File data = new File("data.txt");
    public void test()
    {
        System.out.println("test");
    }
    public void upgrades(int cash)
    {
        
    }
    public void powers(int cash)
    {
        
    }
    public void extras(int cash)
    {
        
    }

    public void setDefaults()
    {
        //File data = new File("data.txt");
        try{
            FileWriter writer = new FileWriter(data);
            writer.write("ZoneValue 0\n");
            writer.write("PollutionControl 1\n");
            writer.write("PublicTransport 0\n");
            writer.write("Taxes 0\n");
            writer.write("Popularity 0\n");
            writer.write("UpgradeCost 250\n");
            ////////////////////////////////
            //Code Below Originally in City.java
            writer.write("Cash 5000\n");
            writer.write("Income 0 \n");
            writer.write("Population 10\n");
            writer.write("Industry 0\n");
            writer.write("Comercial 0\n");
            writer.write("Residential 0\n");
            writer.write("Pollution 0\n");
            ////////////////////////////////
            writer.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
       /* levels.put("zoneValue", 1);
        levels.put("pollutionControl", 1);
        levels.put("publicTransport", 0);
        levels.put("taxes", 1);
        levels.put("popularity", 1);
        */
    }
    public void getLevels()
    {
        try{
           // File data = new File("data.txt");
            Scanner lFind = new Scanner(data);
            System.out.println("Getting Levels");
            System.out.println();
            while(lFind.hasNextLine())
            {
                String search = lFind.nextLine();
                if(search.startsWith("ZoneValue"))
                {
                    String trimed = search.replace("ZoneValue", "").trim();
                    System.out.println("Zone Value Multiplier: " + trimed);
                }else if(search.startsWith("PollutionControl"))
                {
                    String trimed = search.replace("PollutionControl", "").trim();
                    System.out.println("Current Pollution Control Level: " + trimed);
                }else if(search.startsWith("PublicTransport"))
                {
                    String trimed = search.replace("PublicTransport", "").trim();
                    System.out.println("Current Public Transport Level: " + trimed);
                }else if(search.startsWith("Taxes"))
                {
                   String trimed = search.replace("Taxes", "").trim(); 
                   System.out.println("Current Tax Level: " + trimed);
                }else if(search.startsWith("Popularity"))
                {
                   String trimed = search.replace("Popularity", "").trim();
                   System.out.println("Current Popularity Level: " + trimed);
                }
            }
            lFind.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        /*int zoneValue = levels.get("zoneValue");
        int pollutionC = levels.get("pollutionControl");
        int publicTransport = levels.get("publicTransport");
        int taxes = levels.get("taxes");
        int popularity = levels.get("popularity");
        System.out.println("Current Upgrade Levels:");
        System.out.println("Pollution Control: " + pollutionC);
        System.out.println("Taxes: " + taxes);
        System.out.println("Public Trasnprtation: " + publicTransport);
        System.out.println("Zone Value: " + zoneValue);
        System.out.println("Popularity: " + popularity);
        */
        
    }
    public void pollutionControl(int cash)
    {
        int oldPollutionControl = 0;
        int newPollutionControl = 0;
        String oPollutionControl = "";
        String nPollutionControl = "";
        String oldData = "";
        String newData = "";
        BufferedReader reader = null;
        FileWriter writer = null;
       // File data = new File("data.txt");
       upgradeCost();
        try{
            Scanner fPControl = new Scanner(data);
            while(fPControl.hasNextLine())
            {
                String search = fPControl.nextLine();
                if(search.startsWith("PollutionControl"))
                {
                    String trimed = search.replace("PollutionControl", "").trim();
                    oldPollutionControl = Integer.parseInt(trimed);
                }
            }
            fPControl.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldData = oldData + line + System.lineSeparator();
                line = reader.readLine();
            }
            oPollutionControl = ("PollutionControl " + oldPollutionControl).trim();
            nPollutionControl = ("PollutionControl " + (oldPollutionControl + 1)).trim();
            newData = oldData.replaceAll(oPollutionControl.trim(), nPollutionControl.trim());
            writer = new FileWriter(data);
            writer.write(newData);
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                reader.close();
                writer.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void upgradeCost()
    {
        int oldUpgradeCost = 0;
        int newUpgradeCost = 0;
        String oUpgradeCost = "";
        String nUpgradeCost = "";
        String oldData = "";
        String newData = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        //File data = new File("data.txt");
        try{
            Scanner fUpgradeCost = new Scanner(data);
            while(fUpgradeCost.hasNextLine())
            {
                String search = fUpgradeCost.nextLine();
                if(search.startsWith("UpgradeCost"))
                {
                    String trimed = search.replace("UpgradeCost", "").trim();
                    oldUpgradeCost = Integer.parseInt(trimed);
                }
            }
            fUpgradeCost.close();
            
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldData = oldData + line + System.lineSeparator();
                line = reader.readLine();
            }
        newUpgradeCost = oldUpgradeCost + (int)(oldUpgradeCost / 5);
        oUpgradeCost = ("UpgradeCost " + oldUpgradeCost).trim();
        nUpgradeCost = ("UpgradeCost " + newUpgradeCost).trim();
        newData = oldData.replaceAll(oUpgradeCost.trim(), nUpgradeCost.trim());
        writer = new FileWriter(data);
        writer.write(newData);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                reader.close();
                writer.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        
    }
    public void taxes(int cash)
    {
        //File data = new File(data);
        
        int oldLevel = 0;
        int newLevel = 0;
        int cost = 0;
        String oLevel = "";
        String nLevel = "";
        String oldData = "";
        String newData = "";
        FileWriter writer = null;
        BufferedReader reader = null;
        try{
            Scanner sc = new Scanner(data);
            while(sc.hasNextLine())
            {
                String search = sc.nextLine();
                if(search.startsWith("Taxes"))
                {
                    
                    String trimed = search.replace("Taxes", "").trim();
                    oldLevel = Integer.parseInt(trimed);
                }
            }
            
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            Scanner sc = new Scanner(data);
            while(sc.hasNextLine())
            {
                String search = sc.nextLine();
                if(search.startsWith("UpgradeCost"))
                {
                    
                    String trimed = search.replace("UpgradeCost", "").trim();
                    cost = Integer.parseInt(trimed);
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        if((cash-cost)>0)
        {
           try{
               
               reader = new BufferedReader(new FileReader(data));
               String line = reader.readLine();
               while(line != null)
               {
                   oldData = oldData + line + System.lineSeparator();
                   line = reader.readLine();
               }
               newLevel = oldLevel + 1;
               oLevel = ("Taxes " + oldLevel).trim();
               nLevel = ("Taxes " + newLevel).trim();
               newData = oldData.replaceAll(oLevel.trim(), nLevel.trim());
               writer = new FileWriter(data);
               writer.write(newData);
              
           } catch(IOException e)
           {
               e.printStackTrace();
           }
           finally
           {
               try
               {
                   writer.close();
                   reader.close();
               }catch(IOException e)
               {
                   e.printStackTrace();
               }
           }
           System.out.println("Purchase Sucessful");
        }else
        {
            System.out.println("You Do Not Have Enough Cash For That");
            System.out.println();
        }
    }
}