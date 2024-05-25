package test;

public class MainTrain {

	public static class A{
		static int count=0;
		public A(){
			count++;
		}
	}
	public static class B extends A{}
	public static class C extends B{}
	
	
	public static void main(String[] args) {
		GenericFactory<A> factory=new GenericFactory<A>();
		factory.insertProduct("a", A.class);
		factory.insertProduct("b", B.class);
		factory.insertProduct("c", C.class);
		
		A a=factory.getNewProduct("a");
		factory.getNewProduct("a");
		if(A.count!=2)
			System.out.println("failure getting the true number of instances (-25)");
		
		if(!a.getClass().equals(A.class))
			System.out.println("failure creating type A (-25)");
		if(!factory.getNewProduct("b").getClass().equals(B.class))
			System.out.println("failure creating type B(-25)");
		if(!factory.getNewProduct("c").getClass().equals(C.class))
			System.out.println("failure creating type C (-25)");

		System.out.println("done");
		
	}

}
