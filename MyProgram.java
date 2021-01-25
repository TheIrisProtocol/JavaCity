import java.util.*;
import java.io.*;
public class MyProgram 
{
    static Settings settings = new Settings();
    static Shop shop = new Shop();
    static City city = new City();
    static Game game = new Game();
    static boolean gameOver = false;
    static Disasters storm = new Disasters();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        try{
            File data = new File("data.txt");
            if(data.createNewFile())
            {
                System.out.println("Data File Created");
            } else {
                System.out.println("Data file already exists");
            }
        } catch(IOException e)
        {
            System.out.println("Error Setting Defualts \nPlease Restart Game");
            e.printStackTrace();
        }

        shop.setDefaults();
        while(1==1)
        {
            
            System.out.println("Select Menu: \n1.City\n2.Shop\n3.Continue\n4.Settings");
            System.out.println();
            int dayChoice = sc.nextInt();
            System.out.println();
            if(dayChoice == 4)
            {
                System.out.println();
                System.out.println("Select An Option: \n1.End Game\n2.Previous Menu");
                System.out.println();
                int settingChoice = sc.nextInt();
                System.out.println();
                if(settingChoice == 1)
                {
                    System.out.println("Are you sure? (All Data Will Be Erased) \n1.Yes\n2.No");
                    System.out.println();
                    int endGame = sc.nextInt();
                    System.out.println();
                    if(endGame == 1)
                    {
                        break;
                    } else if (endGame == 2)
                    {
                        
                    }
                }
            }
            else if(dayChoice == 3)
            {
            System.out.println("Continue to next day? Y|N");
            System.out.println();
            String nextDay = sc.next().toLowerCase();
            if(nextDay.equals("y"))
            {
                gameOver = game.gameOver();
                if(gameOver)
            {
                break;
            }
            
                game.nextDay();
               game.updatePollution();
               game.updatePop();
               game.updateBalance();
               storm.selectIssue();
               System.out.println("New Balance: " + city.cash());
               gameOver = game.gameOver();
            }
            
            } else if(dayChoice == 1)
            {
                while(1==1)
                {
                System.out.println("Select a Menu: \n1.View Population\n2.View Current Income\n3.View Zone Numbers\n4.View Current Balance\n5.View Pollution Levels\n6.Previous Menu");
                System.out.println();
                int cityChoice = sc.nextInt();
                System.out.println();
                if(cityChoice == 1)
                {
                    city.population();
                    System.out.println();
                } else if(cityChoice == 6)
                {
                 break;   
                } else if(cityChoice == 2)
                {
                    city.income();
                    System.out.println();
                }else if(cityChoice == 3)
                {
                    city.getZones();
                    System.out.println();
                }else if(cityChoice == 4)
                {
                    city.getCash();
                }
                else if(cityChoice == 5)
                {
                    game.getPollution();
                }
                }
            } else if(dayChoice == 2)
            {
                while(1==1)
                {
                    System.out.println("Choose a Menu: \n1.Upgrades\n2.Zones\n3.Powers\n4.Extras\n5.Previous Menu");
                    System.out.println();
                    int shopChoice = sc.nextInt();
                    if(shopChoice == 5)
                    {
                        break;
                    } else if(shopChoice == 1)
                    {
                        while(1==1)
                        {
                            System.out.println("Select An Option: \n1.Purchace Upgrades\n2.View Upgrade Levels\n3.Previous Menu");
                            System.out.println();
                            int upgradeChoice = sc.nextInt();
                            if(upgradeChoice == 3)
                            {
                                break;
                            } else if(upgradeChoice == 2) {
                                shop.getLevels();
                                System.out.println();
                            }else if(upgradeChoice == 1)
                            {
                                while(1==1)
                                {
                                    
                               int cost = game.getUCost();
                        System.out.println("Select an Upgrade To Learn More");
                        System.out.println("1.Pollution Control\n2.Zone Value\n3.Public Transportation\n4.Taxes\n5.Popularity\n6.Previous Menu");
                        int upgradeInfo = sc.nextInt();
                         if(upgradeInfo == 1)
                        {
                            System.out.println("This nullifies the pollution of One Industrial Zone.\nRequired with Industrial Zones to keep people from leaving your city.");
                            System.out.println("Purchase? (" + cost + ") \n1.Yes\n2.No");
                            int buyUpgrade = sc.nextInt();
                            if(buyUpgrade == 1)
                            {
                                shop.pollutionControl(city.cash());
                            }
                        }else if(upgradeInfo == 2)
                        {
                            
                        }else if(upgradeInfo == 3)
                        {
                            
                        }else if(upgradeInfo == 4)
                        {
                            System.out.println("Upgrades your income by \"Income^1.Taxes\"");
                            System.out.println("Purchase? (" + cost + ")\n1.Yes\n2.No");
                            int buyUpgrade = sc.nextInt();
                            if(buyUpgrade == 1)
                            {
                              shop.taxes(city.cash()); 
                              shop.upgradeCost();
                            }
                        }else if(upgradeInfo == 5)
                        {
                            
                        }else if(upgradeInfo == 6)
                        {
                            break;
                        }
                                }
                        
                            }
                        }
                    }else if(shopChoice == 2)
                    {
                        while(1==1)
                        {
                            System.out.println("Please Select A Zone To Buy: \n1.Residential(250)\n2.Comercial(750)\n3.Industrial(2500)\n4.Previous Menu");
                            System.out.println();
                            int zoneChoice = sc.nextInt();
                            if(zoneChoice == 4)
                            {
                                break;
                            }else if(zoneChoice == 1)
                            {
                                city.zones(city.cash(), 1);
                            } else if(zoneChoice == 2)
                            {
                                city.zones(city.cash(), 2);
                            }else if(zoneChoice == 3){
                                city.zones(city.cash(), 3);
                            }
                        }
                    }
            
                }
            }
        }
    }
}