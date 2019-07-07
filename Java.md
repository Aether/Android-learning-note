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
    
#### HashSet

    public static void main(String[] args) {
        HashSet<String> s = new HashSet<String>();
        s.add("first");
        s.add("second");
        s.add("first");//{first,second}
    }

##### Use StringBuffer instead of add string
    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();
        if (northExit != null) {
            sb.append("north ");
        }
        if (southExit != null) {
            sb.append("south ");
        }
        if (eastExit != null) {
            sb.append("east ");
        }
        if (westExit != null) {
            sb.append("west ");
        }
        return sb.toString();
    }

####    Handler

    public class Game {
        private HashMap<String, Handler> handlers = new HashMap<String, Handler>;
        public Game() {
            handlers.put("bye", new HandlerBye());
        }
    }
    
    public class Handler {
        public void doCmd(String word) {
            public boolean isBye() {
                return flase;
            }
        }
    }
    
    public class HandlerBye extends Handler {
        @Override
        public boolean isBye() {
            return true;
        }
    }
    
#### Abstract

    public abstract class Shape {
        
        public abstract void draw(Graphics g);
        
    }
    
Abstract class can't generate object,but it can define variable.

A subclass of an abstractclass must override abstract function in the super class.

#### Interface

Interface is abstract class.All member functions and member variables are **public static final**.

    public class Fox extends Animal implements Cell {
        //......
    }
    
    public interface Cell {
        //......
    }
    
- Interface can inherit interface, but it can't inherit class.

- Class can implement many interfaces,but interface can't implement interface.


    
#### Exception

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
    

---

#### Stream
##### InputStream
- int available();
- void close;
- void mark(int readlimit);
- boolean markSupported();
- abstract int read();
- int read(byte[] b);
- int read(byte[] b, int off, int len);
- void reset();
- long skip(long n);

##### OutputStream
- void close();
- void flush();
- void write(byte[] b);
- void write(byte[] b, int off, int len);
- abstract void write(int b);


        public class Main{
           public class void main(String[] args) {
            System.out.println("hello world");
            byte[] buffer = new byte[1024];
            try {
                int len = System.in.read(buffer);//len->GB code
                String s = new String(buffer, 0, len);//s.length->Unicode
            } catch (IOException e)
                e.printStackTrace();
            } 
        }
    
##### FileInputStream/FileOutputStream

        public class Main{
           public class void main(String[] args) {
            System.out.println("hello world");
            byte[] buffer = new byte[10];
            for (int i = 0; i<buffer.length; i++) {
                buffer[i] = (byte)i;
            }
            try {
                FileOutputStream out = new FileOutputStream("a.dat");
                out.write(buffer);
                out.close
            } catch (FileNotFoundException e)
                e.printStackTrace();
            } catch (IOException e)
                e.printStackTrace();
            } 
        }
        
##### Stream Filter

    try {
        DataOutputStream out = new DataOutputStream(
                        new BufferedOutputStream(
                 new FileOutputStream("a.dat")));
                 //binary input and output
    }
    
##### Reader/Writer

    
    PrintWriter out = new PrintWriter(
        new BufferWriter(
            new OutputStreamWriter(
                new FileOutputStream("a.txt"))));
                
    int i = 123456;
    out.println(i); //Unicode -> ASCII or GB code
    
    BufferedReader in = new BufferedReader(
        new InputStreamReader(
            new FileInputStream("src/hello/Main.java")));
            
    String line;
    while ((line = in.readLine()) != null) {
        System.out.println(line);
    }
    
- BufferedReader readLine();
- LineNumberReader getLineNumber();

~~~
    BufferedReader in = new BufferedReader(
        new InputStreamReader(
            new FileInputStream("utf8.txt"), "utf8"));
~~~
            
            
##### Stream/Reader/Scanner
binary -> InputStream

text -> Reader

data -> Scanner

##### Socket

    public class Main {
        public static void main(String[] args) {
            try {
                Socket socket = new Socket(InetAddress.getByName("localhost"),12345);
                PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream)));
                out.println("Hello");
                out.flush();
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                        socket.getInputStream()));
                String line;
                line = in.readLine();
                System.out.println(line);
                out.close;
                socket.close();
            } catch(IOException e){
                e.printStackTrace;
            }
        }
    }
    
terminal

    nc -l 12345
    
- the read()/nextInt()/readLine() function is blocked,you can use thread of use nio channel
- for socket,we can set SO time
    
    setSoTimeout(int timeOut)

#### Object Serialization
- ObjectInputStream class
- readObject();
 


    class Student implements Serializable {
        private String name;
        private int age;
        private int grade;
    
        public Student(String name, int age, int grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    
         public String toString() {
             return name+" "+age+" "+grade;
         }
    }
    
    public class Main {
        public static void main(String[] args) {
            try {
                Student s1 = new Student("John",18,5);
                System.out.println(s1);
                ObjectOutputStream out = new ObjectOutputStream(
                        new FileOutputStream("obj.dat"))
                out.writeObject(s1);
                out.close();
                ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("obj.dat"));
                Student s2 = (Student)in.readObject();
                System.out.println(s2);//s1!=s2
                in.close;
            } catch (IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }

#### Inversion of Control

    JButton btnStep = new JButton("Button");
    frame.add(btnStep, BorderLayout.NORTH);
    btnStep.addActionListener(new ActionListener() { 
        @Override
        public void actionPerformed(Action e) {
            //.....
        }
    });
    
##### Inner class 
Inner class is defined in class or function, it can access all the resources outside, including any private member.(If it is defined in a function,it can only access the final variable.)

##### Anonymous Class
Anonymous Class can inherit class and implement interface.

