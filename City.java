import java.util.*;
import java.io.*;
public class City {
   public HashMap<String, Integer> stats = new HashMap<String, Integer>();
    
    public void population()
    {
        try{
                File pop = new File("data.txt");
                Scanner fPop = new Scanner(pop);
                while(fPop.hasNextLine())
                {
                    String search = fPop.nextLine();
                    if(search.startsWith("Population"))
                    {
                        System.out.println("Current Population: " + search.replace("Population", "").trim());
                    }
                }
                
                System.out.println();
                fPop.close();
            } catch(FileNotFoundException e)
            {
                System.out.println("Error finding population. Please Restart Game.");
                e.printStackTrace();
            }
    }
    public void income()
    {
        try{
            File income = new File("data.txt");
            Scanner fIncome = new Scanner(income);
            while(fIncome.hasNextLine())
            {
                String search = fIncome.nextLine();
                if(search.startsWith("Income"))
                {
                    System.out.println("Current Income: " + search.replace("Income", "").trim());
                }
            }
            fIncome.close();
        } catch(FileNotFoundException e)
        {
            System.out.println("Error Finding Income\nPlease Restart Game");
            e.printStackTrace();
        }
    }
    public void getPopulation()
        {
            
            //System.out.println("Current Population: " + stats.get("Population"));
        }
    
    public void industry()
    {
        
    }
    public void comercial()
    {
        
    }
    public void residential()
    {
        
    }
    public void zones(int cash, int zoneType)
    {
        Game game = new Game();
        if((cash - 250) > 0 && zoneType == 1)
        {
            
            BufferedReader reader = null;
            FileWriter writer = null;
            File data = new File("data.txt");
            int oldZone = updateRZone();
            String oldData = "";
            String newData = "" + oldZone;
            String oldNumber = "";
            try
            {
                File file = new File("data.txt");
                Scanner find = new Scanner(file);
                while(find.hasNextLine())
                {
                    String search = find.nextLine();
                    if(search.startsWith("Residential"))
                    {
                        oldData = search.replace("Residential", "").trim();
                    }
                }
                find.close();
                
            } catch(FileNotFoundException e)
            {
                System.out.println("Error Purchasing Zone\nPlease Restart Game");
                e.printStackTrace();
            }
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldNumber = oldNumber + line + System.lineSeparator();
                line = reader.readLine();
            }
            oldData = "Residential " + oldData;
            newData = "Residential " + newData;
            String newContent = oldNumber.replaceAll(oldData.trim(), newData.trim());
            writer = new FileWriter(data);
            writer.write(newContent);
            
        }catch(IOException e)
        {
            System.out.println("Error Purchasing Zone\nPlease Restart Game");
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
                System.out.println("Error Purchasing Zone\nPlease Restart Game");
                e.printStackTrace();
            }
        }
            System.out.println("Purchase Sucessful");
            game.updateCash(cash - 250);
        }else if((cash-750) > 0 && zoneType == 2){
            game.updateIncome(185);
            BufferedReader reader = null;
            FileWriter writer = null;
            File data = new File("data.txt");
            int oldZone = updateCZone();
            String oldData = "";
            String newData = "" + oldZone;
            String oldNumber = "";
            try
            {
                File file = new File("data.txt");
                Scanner find = new Scanner(file);
                while(find.hasNextLine())
                {
                    String search = find.nextLine();
                    if(search.startsWith("Comercial"))
                    {
                        oldData = search.replace("Comercial", "").trim();
                    }
                }
                find.close();
                
            } catch(FileNotFoundException e)
            {
                System.out.println("Error Purchasing Zone\nPlease Restart Game");
                e.printStackTrace();
            }
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldNumber = oldNumber + line + System.lineSeparator();
                line = reader.readLine();
            }
            oldData = "Comercial " + oldData;
            newData = "Comercial " + newData;
            String newContent = oldNumber.replaceAll(oldData.trim(), newData.trim());
            writer = new FileWriter(data);
            writer.write(newContent);
            
        }catch(IOException e)
        {
            System.out.println("Error Purchasing Zone\nPlease Restart Game");
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
                System.out.println("Error Purchasing Zone\nPlease Restart Game");
                e.printStackTrace();
            }
        }
            System.out.println("Purchase Sucessful");
            game.updateCash(cash - 750);
            
        } else if((cash-2500) > 0 && zoneType == 3){
            game.updateIncome(625);
            BufferedReader reader = null;
            FileWriter writer = null;
            File data = new File("data.txt");
            int oldZone = updateIZone();
            String oldData = "";
            String newData = "" + oldZone;
            String oldNumber = "";
            try
            {
                File file = new File("data.txt");
                Scanner find = new Scanner(file);
                while(find.hasNextLine())
                {
                    String search = find.nextLine();
                    if(search.startsWith("Industry"))
                    {
                        oldData = search.replace("Industry", "").trim();
                    }
                }
                find.close();
                
            } catch(FileNotFoundException e)
            {
                System.out.println("Error Purchasing Zone\nPlease Restart Game");
                e.printStackTrace();
            }
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldNumber = oldNumber + line + System.lineSeparator();
                line = reader.readLine();
            }
            oldData = "Industry " + oldData;
            newData = "Industry " + newData;
            String newContent = oldNumber.replaceAll(oldData.trim(), newData.trim());
            writer = new FileWriter(data);
            writer.write(newContent);
            
        }catch(IOException e)
        {
            System.out.println("Error Purchasing Zone\nPlease Restart Game");
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
                System.out.println("Error Purchsing Zone\nPlease Restart Game");
                e.printStackTrace();
            }
        }
            System.out.println("Purchase Sucessful");
            game.updateCash(cash - 2500);
            
            }else {
            System.out.println("You Do Not Have Enough Cash For That!");
            
        }
    }
    public void getIncome()
    {
        System.out.println("Current Income: " + stats.get("Income"));
    }
    public void getZones()
    {
        try{
            File zones = new File("data.txt");
            Scanner fZones = new Scanner(zones);
            while(fZones.hasNextLine())
            {
                String search = fZones.nextLine();
                if(search.startsWith("Residential"))
                {
                    System.out.println("Residential: " + search.replace("Residential", "").trim());
                } else if(search.startsWith("Comercial"))
                {
                    System.out.println("Comercial: " + search.replace("Comercial", "").trim());
                }else if(search.startsWith("Industry"))
                {
                    System.out.println("Industrial: " + search.replace("Industry", "").trim());
                }
            }
            fZones.close();
        }catch(FileNotFoundException e)
        {
            System.out.println("Error Getting Zone Numbers\nPlease Restart Game");
            e.printStackTrace();
        }
    }
    public int nDayIncome()
    {
        int income =  stats.get("Income");
        return income;
    }
    public void nDayPopulation()
    {
        int oldPop = stats.get("Population");
        int newPop;
        int rZones = stats.get("Residential");
        newPop = oldPop + (int)(rZones*2.5);
        stats.remove("Population");
        stats.put("Population", (int)newPop);
        System.out.println("New Population: " + (int)newPop);
        System.out.println();
    }
    public void nDayPollution()
    {
        int iZones = stats.get("Industry");
        int pLevel = stats.get("Pollution");
        int newPLevel;
        if(iZones != pLevel)
        {
        newPLevel = pLevel + (int)iZones;
        } else {
          newPLevel = pLevel;  
        }
        stats.remove("Pollution");
        stats.put("Pollution", newPLevel);
        System.out.println("New Pollution Level: " + newPLevel);
        System.out.println();
        
    }
        public boolean gameOverCheck()
    {
        boolean gameOver = false;
        int pop = stats.get("Population");
        if(pop < 1)
        {
            gameOver = true;
            System.out.println("Game Over. Everyone left your city!");
        }
        
        return gameOver;
    }
    public void getCash()
    {
            String sCash = "";
            int iCash = 0;
            File cash = new File("data.txt");
        try{
            
            Scanner fCash = new Scanner(cash);

            while(fCash.hasNextLine())
            {
                String search = fCash.nextLine();
                if(search.startsWith("Cash"))
                {
                   //System.out.println("Current Balance: " + search.replace("Cash", "").trim());
                    try{
                        sCash = search.replace("Cash", "").trim();
                        iCash = Integer.parseInt(sCash);
                        System.out.printf("%s%,d%n", "Current Balance: ", iCash);
                        
                    }catch(NumberFormatException e)
                    {
                        System.out.println("Error Getting Cash\nPlease Restart Game");
                        e.printStackTrace();
                    }
                }
            }
            
        }catch(FileNotFoundException e)
        {
            System.out.println("Error Finding Cash\nPlease Restart Game");
            e.printStackTrace();
        }
    }
    public int cash()
    {
        int cBalance = 0;
        int rBalance = 0;
        String sBalance = "";
        try{
            File cash = new File("data.txt");
            Scanner fCash = new Scanner(cash);
            while(fCash.hasNextLine())
            {
                String search = fCash.nextLine();
                if(search.startsWith("Cash"))
                {
                    sBalance = search.replace("Cash", "").trim();
                    cBalance = Integer.parseInt(sBalance);
                    return cBalance;
                }
            }
            fCash.close();
        }catch(FileNotFoundException e)
        {
            System.out.println("Error Finding Cash\nPlease Restart Game");
            e.printStackTrace();
        }
        //try{
           // cBalance = Integer.parseInt(sBalance);
           // return cBalance;
       // }catch(NumberFormatException e)
       // {
        //   System.out.println("Error Getting Cash\nPlease Restart Game");
         //   e.printStackTrace();
        //}
        return cBalance;
    }
    public int updateRZone()
    {
        int oldZone = 0;
        int newZone = 0;
        File data = new File("data.txt");
        
        try{
            Scanner fData = new Scanner(data);
            while(fData.hasNextLine())
            {
                String search = fData.nextLine();
                if(search.startsWith("Residential"))
                {
                    String string = search.replace("Residential", "").trim();
                    try{
                        oldZone = Integer.parseInt(string);
                        newZone = oldZone + 1;
                        return newZone;
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return newZone;
    }
    public int updateCZone()
    {
        int oldZone = 0;
        int newZone = 0;
        File data = new File("data.txt");
        
        try{
            Scanner fData = new Scanner(data);
            while(fData.hasNextLine())
            {
                String search = fData.nextLine();
                if(search.startsWith("Comercial"))
                {
                    String string = search.replace("Comercial", "").trim();
                    try{
                        oldZone = Integer.parseInt(string);
                        newZone = oldZone + 1;
                        return newZone;
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return newZone;
    }
    public int updateIZone()
    {
        int oldZone = 0;
        int newZone = 0;
        File data = new File("data.txt");
        
        try{
            Scanner fData = new Scanner(data);
            while(fData.hasNextLine())
            {
                String search = fData.nextLine();
                if(search.startsWith("Industry"))
                {
                    String string = search.replace("Industry", "").trim();
                    try{
                        oldZone = Integer.parseInt(string);
                        newZone = oldZone + 1;
                        return newZone;
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return newZone;
    }
}