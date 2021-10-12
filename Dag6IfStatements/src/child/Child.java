package child;


public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		String whichInstitution = "";

		if (age == 0){
			whichInstitution = "Home";
		} else if (age > 2){
			whichInstitution = "Nursery";
		} else if (age < 6){
			whichInstitution = "Kindergarden";
		} else if (age < 16){
			whichInstitution = "School";
		} else if (age >= 17){
			whichInstitution = "Out of school";
		} else{
			whichInstitution = "Thats a weird age";
		}
		return whichInstitution;
	}

	public String gender(){
		String gender = "";
		if (boy){
			gender = "Boy";
		} else {
			gender = "Girl";
		}
		return gender;
	}

	public String team(){
		String team = "";
		if (boy){
			if (age < 8){
				team = "Young Cubs";
			} else{
				team = "Cool Boys";
			}
		} else {
			if (age < 8){
				team = "Tumbling Girls";
			}else{
				team = "Springy Girls";
			}
		}
		return team;
	}

}
