### Basic Grammer
#### val&var

    a:Int 
    val b:Int = 2 //val variable can only be assignmented once
    val c = "Hello Kotlin"
    val d // wrong
    val e:Int //right
    var f : Char = '1'
    
#### fun

    fun main(arg:Array<String>) {
        
        fun sum(): Unit {
            print("param:void,return:void")
        }
        
        fun sum(): Unit {
            print("Unit can be omitted")
        }
        
        fun sum(a:Int): Int {
            print("param:int,return:int")
        }
        
        fun sum(a:Int, b:Int) = a + b;
        
        fun maxOf(a: Int, b: Int) = if (a > b) a else b
        
        fun parseInt(str: String): Int? {
            return null;//?means possible return null
        }
    }
    
#### String

    val boy = 5
    var girl = 7
    var all = "There are $boy boys and $girl girls"
    print(all)
    val text = """
        for (c in "foo")
            print(c)
        """
    
#### instanceof()

    var a:Any = "123"//Any is commom parent class of all classes
    if (a is String){
        print(a.length)//meanwhile type conversion
    }
    
#### Circulation

    var a = listOf(1, 2, 3, 1)
    for (b in a) {
        print(b + "\n") //wrong
        print("$b \n")  //right
    }
    for (b in a.indices) {
        print("item:" + b + "值" + a[b] + "\n")
    }
    print("item:$b 值${a[b]}\n")
    for ((a,b)in items.withIndex()) print("$a, $b\n")
    //0,1 1,2 2,3 3,1
    var items = listOf(1, 3, 5, 7, 9)

    for (a in items) {
        if (a == 5) {
            continue | break | return
        }
        print("$a \n")//1,3,7,9
    }
    
#### When

    var x = 1;
    var y = 1;
    when (x) {
        1 ->
            if (x + y > 5) {
                print("a")
            } else {
                print("b")
            }
        2 -> print("x == 2")
        else -> { 
            print("x is neither 1 nor 2")
        }
    }
    
#### Range 

    val x = 5
    if (x in 1..10) {
        println("fits in range")
    }
    
#### Set

    var a = listOf(1, 2, 3, 1)
    for (b in a) {
        print("$b \n")
    }
    
#### Underline

    val oneMillion = 1_000_000 //100000
    val creditCardNumber = 1234_5678_9012_3456L //1234567890123456
    
#### equals

    val a: Int = 10000
    print(a === a) //true
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    print(boxedA === anotherBoxedA) //false 
    
#### Type Conversion

    val b: Byte = 1
    val i: Int = b.toInt()
    
#### Array

    val items = listOf<String>("1","2","3")
    val itemNulls = arrayOfNulls<Int>(10)
    //null
    val asc = Array(5, { i -> (i * i).toString() }) 
    //["0", "1", "4", "9", "16"]
    val asc = Array(5, {i -> (i * i)})
    // [0, 1, 4, 9, 16]
    
#### Constructor

    class TestClass {
        class TestClass constructor(firstName: String) {
            init {
                //Initialize 
            }
        }
        constructor(firstName: String) {
            print("subconstructor")
        }
    }
    class Person {
        constructor(parent: Person) {
            parent.children.add(this)
        }
    }
    class Test{
        val test = TestClass("Kotlin");//new object
    }

#### Extend

    open class BaseClass {
        class BaseClass constructor(str:String){
        
        }
     }
    class SubClass : BaseClass(){

    }
If there isn't a constructor in class, every subconstructor must use the key word "super" to initialize.

    class MyView : View {
        constructor(ctx: Context) : super(ctx)
        constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    }

#### Override

    open class Base {
        open var a = 9;
        open fun v() {
            print("Base...")
        }
        fun nv() {}
    }
    class Subclass() : Base() {
        override var a = 8;//override attribute
        override fun v() {
            //super.v() call the method in baseclass
            print("Subclass...")//override method
        }
    }
    fun main(args: Array<String>) {
        val sub = Subclass();
        son.v()
        print(son.a)
    }
    
