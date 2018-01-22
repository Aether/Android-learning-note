
#### HashMap
    public class Coin {
    
        private HashMap<Integer, String> coinnames = new HashMap<Integer, String>();
        
        public Coin() {
            coinnames.put(1, "penny");
            coinnames.put(10, "dime");
            coinnames.put(25, "quarter");
            coinnames.put(50, "half-dollar");
            coinnames.put(50, "0.5");
        }
        
        public String getName(int amount) {
            return coinnames.get(amount);
        }
        
        public static void main(String[] args)
            Scanner in = new Scanner(System.in);
            int amount = in.nextInt();
            Coin coin = new Coin();
    }
    
####     Exception
    int[] a = new int[10];
    int idx;
    Scanner in = new Scanner(System.in);
    idx = in.nextInt();
    try {
        a[idx] = 10;
        System.out.println("hello");
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Caught");
    }
    
    try {
        // possible exception
    } catch (Type1 id1){
        // deal with it
    } catch (Type2 id2){
        // deal with it
    } catch (Type3 id3){
        // deal with it
    }
    
when it catches an exception in a function,it won't lead to the termination, instead, it will go back the code where the function was called,skip over the function and continue running.
    
    try {
        
    } catch (Exception e) {
        System.out.println("caught");
        System.out.println(e.getMessage);
        System.out.println(e);
        e.printStackTrace();
    }


- String getMessage();
- void printStackTrace();
    
      
    try{

    } catch (Exception e) {
        System.err.println("An exception was thrown");
        throw e;
    }
If you can't deal with the exception, you can throw it again.
    
    class OpenException extends Throwable {
        
    }
    
    public class ArrayIndex{
    
        public static void readFile() throws OpenException {
            throw new OpenException();
        }
        
        public static void main(String[] args) {
            try {
                readFile();
            } catch (OpenException e) {
                
            }
        }
    }
    
- throw new Exception();
- throw new Exception("ERROR~");

When you override a function,subclass can't declare more exception than superclass.

All the possible exceptions must be declared in the constructor of subclass.
    
    