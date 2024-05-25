package test;


import java.util.HashMap;

public class GenericFactory<Product> {
	
	private interface Creator<Product>{
		public Product create(); // no unhandled exceptions
	}

	HashMap<Object, Creator<Product>> map;

	public GenericFactory(){
		map= new HashMap<>();
	}
	
	public void insertProduct(String key, Class<? extends Product> c) {
		map.put(key, new Creator<Product> () {
			@Override
			public Product create() {
                try {
					return c.newInstance();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return null;
            }
		});

	}	
	
	public Product getNewProduct(String key){
		return (Product) map.get(key).create();
	}
}
