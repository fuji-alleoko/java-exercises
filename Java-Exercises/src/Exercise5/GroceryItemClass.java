package Exercise5;

public class GroceryItemClass {
	 
	        private int id;
	        private String product;
	        private double price;
	        private double discount;

	        public GroceryItemClass(int id, String product, double price, double discount) {
	            this.id = id;
	            this.product = product;
	            this.price = price;
	            this.discount = discount;
	        }

	        public int getId() {
	            return id;
	        }

	        public String getProduct() {
	            return product;
	        }

	        public double getPrice() {
	            return price;
	        }

	        public double getDiscount() {
	            return discount;
	        }      }