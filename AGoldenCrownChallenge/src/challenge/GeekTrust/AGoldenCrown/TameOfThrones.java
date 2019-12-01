package challenge.GeekTrust.AGoldenCrown;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TameOfThrones {
	
    private ArrayList<String> allies = new ArrayList<String>();
    private Map<String,String> message= new TreeMap<String,String>();
    private Map<String,String> legend= new TreeMap<String,String>();

    public static void main(String[] args) {

        //Printing the default values for rulers and allies
        System.out.println("Who is the ruler of Southeros?");
        String ruler = "None";
        System.out.println("Output: "+ ruler);
        System.out.println("Who is the ruler of Southeros?");
        System.out.println("Output: None" );
        
        TameOfThrones tot = new TameOfThrones();
        tot.decidingRuler();
        
        System.out.println("Who is the ruler of Southeros?");
        ruler = "King Shan";
        System.out.println("Output: "+ ruler);
        System.out.println("Allies of Ruler");
        System.out.print("Output: ");
        
        tot.printAllies();

    }
    
    private void printAllies() {
        //Printing all the allies
        for (String string : allies) {
            System.out.print(string+",");
        }
	}

	private void decidingRuler() {
        getInput4mUser();        
        
        initEmblems();

        getAlliesForMsg(allies,message);


    }
	private  void getInput4mUser() {
        //Letting user choose how many inputs they want
        Scanner sc = new Scanner(System.in);
        System.out.println("How many messages you want to send?");
        int n=Integer.parseInt(sc.nextLine());
        //System.out.println(n);
        System.out.println("Input Messages to kingdoms from King Shan:");
        
        storingMsg(n, sc);        
	}
	
	private  void storingMsg(int n ,Scanner sc) {
        //Storing all the messages in TreeMap named "message"
        for(int i =1;i<=n;i++) 
        {
            System.out.print("Input:");
            String str = sc.nextLine();
            String[] arr= str.split(",", 2);
            message.put(arr[0], arr[1]);
            System.out.println(" ");
        }
	}

	private  void getAlliesForMsg(ArrayList<String> allies, Map<String, String> message) {
        //For checking whether the message is correct
        //Taking each message and comparing it with the legend
        for(Map.Entry<String,String> entry : message.entrySet() )
        {
                String emblem = legend.get(entry.getKey());
                String msg = message.get(entry.getKey());
                
                int count=0;
                
                for(int i =0;i<emblem.length();i++)
                {   
                	char[] first = emblem.toLowerCase().toCharArray(); 
                    char[] second = msg.toLowerCase().toCharArray();
                    //System.out.println("fisrt: "+first[i]);
                    for(int j=0;j<msg.length();j++)
                    {    
                        if(first[i]==second[j])
                            {    //System.out.println("second: "+second[j]);
                                second[j]='*';
                                count=count+1;
                                break;    
                            }
                    }
                    //System.out.println("COunt: "+count);
                    if(emblem.length()==count) 
                    {
                        allies.add(getKey(legend, emblem));
                    }                    
                }                
        }

	}
	
    /**
     * Getting the key from the value
     * @param legend
     * @param emblem
     * @return
     */
	public static String getKey(Map<String,String> legend,String emblem){
        for(String key:legend.keySet()) {
            if(emblem.equals(legend.get(key)))
            { return key;}
        }
        return null;
        }
	
	/**
	 * Storing all the Emblems for corresponding Kingdoms
	 */
	private void initEmblems() {
        
        legend.put("Land", "Panda");
        legend.put("Water", "Octopus");
        legend.put("Ice", "Mammoth");
        legend.put("Air", "Owl");
        legend.put("Fire", "Dragon");
        legend.put("Space", "Gorilla");
	}
	
	
	
}
