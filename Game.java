import java.util.*;
import java.io.*;
public class Game {
        City city = new City();
        public Shop shop = new Shop();
        
    private static void main(String[] args) {
    }
    public void gameStatus()
    {
        
    }
    public void nextDay()
    {
        System.out.println();
        System.out.println("New Day!");
        System.out.println();

    }
    public int nDayIncome()
    {
        int income = city.nDayIncome();
        System.out.println("Money Earned: " + income);
        return income;
    }
    public void updateCash(int newBal)
    {
        File data = new File("data.txt");
        String oldData = "";
        String newData = ("Cash " + newBal).trim();
        String oldBalance = "";
        try{
            File cash = new File("data.txt");
            Scanner fCash = new Scanner(cash);
            while(fCash.hasNextLine())
            {
                String search = fCash.nextLine();
                if(search.startsWith("Cash"))
                {
                    oldData = search.replace("Cash", "").trim();
                }
            }
            fCash.close();
            
        }catch(FileNotFoundException e)
        {
            System.out.println("Error Upadting Balance\nPlease Restart Game");
            e.printStackTrace();
        }
        BufferedReader reader = null;
        FileWriter writer = null;
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldBalance = oldBalance + line + System.lineSeparator();
                line = reader.readLine();
            }
            oldData = "Cash " + oldData;
            String newContent = oldBalance.replaceAll(oldData.trim(), newData.trim());
            writer = new FileWriter(data);
            writer.write(newContent);
            
        }catch(IOException e)
        {
            System.out.println("Error Updating Balance\nPlease Restart Game");
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
                System.out.println("Error Updating Balance\nPlease Restart Game");
                e.printStackTrace();
            }
        }
        
    }
    public void updateIncome(int increase)
    {
        int oldIncome = 0;
        String oldData = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        File data = new File("data.txt");
        try{
            Scanner iFind = new Scanner(data);
            while(iFind.hasNextLine())
            {
                String search = iFind.nextLine();
                if(search.startsWith("Income"))
                {
                    String iTrimed = search.replace("Income", "").trim();
                    oldIncome = Integer.parseInt(iTrimed);
                }
            }
            iFind.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        int newIncome = oldIncome + increase;
        String nIncome = ("Income " + newIncome).trim();
        String oIncome = ("Income " + oldIncome).trim();
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldData = oldData + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newData = oldData.replaceAll(oIncome.trim(), nIncome.trim());
            writer = new FileWriter(data);
            writer.write(newData);
            System.out.println("Old Income: " + oIncome);
            System.out.println("New Income: " + nIncome);
            System.out.println();
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
    public void updatePop()
    {
        int rZones = 0;
        int oldPop = 0;
        int newPop = 0;
        String oPop = "";
        String nPop = "";
        String oldData = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        File data = new File("data.txt");
        try{
            Scanner fRZones = new Scanner(data);
            while(fRZones.hasNextLine())
            {
                String search = fRZones.nextLine();
                if(search.startsWith("Residential"))
                {
                    String trimed = search.replace("Residential", "").trim();
                    rZones = Integer.parseInt(trimed);
                }
            }
            fRZones.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            Scanner fPop = new Scanner(data);
            while(fPop.hasNextLine())
            {
                String search = fPop.nextLine();
                if(search.startsWith("Population"))
                {
                    String trimed = search.replace("Population", "").trim();
                    oldPop = Integer.parseInt(trimed);
                }
            }
            fPop.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        newPop = (int)(oldPop + (Math.pow((double)rZones, 2.0)));
        oPop = ("Population " + oldPop).trim();
        nPop = ("Population " + newPop).trim();
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldData = oldData + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newData = oldData.replaceAll(oPop.trim(), nPop.trim());
            writer = new FileWriter(data);
            writer.write(newData);
            System.out.println("New Population: " + newPop);
            System.out.println();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                writer.close();
                reader.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void updatePollution()
    {
        File data = new File("data.txt");
        int oldPollution = 0;
        int newPollution = 0;
        int iZones = 0;
        int pControl = 0;
        String oPollution = "";
        String nPollution = "";
        String oldData = "";
        String newData = "";
        try{
            Scanner fIZones = new Scanner(data);
            while(fIZones.hasNextLine())
            {
                String search = fIZones.nextLine();
                if(search.startsWith("Industry"))
                {
                    String trimed = search.replace("Industry", "").trim();
                    iZones = Integer.parseInt(trimed);
                }
            }
            fIZones.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            Scanner fPollution = new Scanner(data);
            while(fPollution.hasNextLine())
            {
                String search = fPollution.nextLine();
                if(search.startsWith("Pollution "))
                {
                    String trimed = search.replace("Pollution ", "").trim();
                    oldPollution = Integer.parseInt(trimed);
                }
            }
            fPollution.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            Scanner pollutionC = new Scanner(data);
            while(pollutionC.hasNextLine())
            {
                String search = pollutionC.nextLine();
                if(search.startsWith("PollutionControl"))
                {
                    String trimed = search.replace("PollutionControl", "").trim();
                    pControl = Integer.parseInt(trimed);
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        newPollution = oldPollution + (iZones - pControl);
        if(newPollution <= 0)
        {
            newPollution = 0;
        }
        if(newPollution > iZones)
        {
            newPollution = iZones;
        }
        BufferedReader reader = null;
        FileWriter writer = null;
        try{
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldData = oldData + line + System.lineSeparator();
                line = reader.readLine();
            }
            oPollution = ("Pollution " + oldPollution).trim();
            nPollution = ("Pollution " + newPollution).trim();
            newData = oldData.replaceAll(oPollution.trim(), nPollution.trim());
            writer = new FileWriter(data);
            writer.write(newData);
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                writer.close();
                reader.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void getPollution()
    {
        File data = new File("data.txt");
        try
        {
            Scanner fPollution = new Scanner(data);
            while(fPollution.hasNextLine())
            {
                String search = fPollution.nextLine();
                if(search.startsWith("Pollution "))
                {
                    System.out.println("Current Pollution Level: " + (search.replace("Pollution", "").trim()));
                    System.out.println();
                }
            }
            fPollution.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public int getUCost()
    {
        int cost = 0;
       File data = new File("data.txt");
       try{
           Scanner upgradeCost = new Scanner(data);
           while(upgradeCost.hasNextLine())
           {
               String search = upgradeCost.nextLine();
               if(search.startsWith("UpgradeCost"))
               {
                   String trimed = search.replace("UpgradeCost", "").trim();
                   cost = Integer.parseInt(trimed);
               }
           }
           upgradeCost.close();
       }catch(FileNotFoundException e)
       {
           e.printStackTrace();
       }
       return cost;
    }
    public boolean gameOver()
    {
        File data = new File("data.txt");
        int oldPop = 0;
        int newPop = 0;
        int pollution = 0;
        boolean gameOver = false;
        BufferedReader reader = null;
        FileWriter writer = null;
        String oPop = "";
        String nPop = "";
        String newData = "";
        String oldData = "";
        try{
            Scanner sc = new Scanner(data);
            while(sc.hasNextLine())
            {
                String search = sc.nextLine();
                if(search.startsWith("Population"))
                {
                    String trimed = search.replace("Population", "").trim();
                    oldPop = Integer.parseInt(trimed);
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            Scanner sc = new Scanner(data);
            while(sc.hasNextLine())
            {
                String search = sc.nextLine();
                if(search.startsWith("Pollution "))
                {
                    String trimed = search.replace("Pollution ", "").trim();
                    pollution = Integer.parseInt(trimed);
                }
            }
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
            newPop = (int)(oldPop - (int)(Math.pow(pollution, 3)));
            oPop = ("Population " + oldPop).trim();
            nPop = ("Population " + newPop).trim();
            newData = oldData.replaceAll(oPop.trim(), nPop.trim());
            writer = new FileWriter(data);
            writer.write(newData);
        }catch(IOException e)
        {
            e.printStackTrace();
        } 
        finally
        {
            try{
                writer.close();
                reader.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        if(newPop <= 0)
        {
            gameOver = true;
        }else{
            gameOver = false;
        }
        return gameOver;
    }
    public void updateBalance()
    {
        File data = new File("data.txt");
        int oldBalance = 0;
        int newBalance = 0;
        int income = 0;
        double taxes = 0.0;
        String oBalance = "";
        String nBalance = "";
        String oldData = "";
        String newData = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try{
            Scanner sc = new Scanner(data);
            while(sc.hasNextLine())
            {
                String search = sc.nextLine();
                if(search.startsWith("Taxes"))
                {
                    String trimed = search.replace("Taxes", "").trim();
                    taxes = (double)(Integer.parseInt(trimed));
                    taxes /= 10;
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            Scanner sc = new Scanner(data);
            while(sc.hasNextLine())
            {
                String search = sc.nextLine();
                if(search.startsWith("Cash"))
                {
                    String trimed = search.replace("Cash", "").trim();
                    oldBalance = Integer.parseInt(trimed);
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            Scanner sc = new Scanner(data);
            while(sc.hasNextLine())
            {
                String search = sc.nextLine();
                if(search.startsWith("Income"))
                {
                    String trimed = search.replace("Income", "").trim();
                    income = Integer.parseInt(trimed);
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            reader = new BufferedReader(new FileReader(data));
            String line = reader.readLine();
            while(line != null)
            {
                oldData = oldData + line + System.lineSeparator();
                line = reader.readLine();
            }
            newBalance = oldBalance + (int)(Math.pow(income, (taxes + 1)));
            oBalance = ("Cash " + oldBalance).trim();
            nBalance = ("Cash " + newBalance).trim();
            newData = oldData.replaceAll(oBalance.trim(), nBalance.trim());
            writer = new FileWriter(data);
            writer.write(newData);
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try{
                writer.close();
                reader.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    
}