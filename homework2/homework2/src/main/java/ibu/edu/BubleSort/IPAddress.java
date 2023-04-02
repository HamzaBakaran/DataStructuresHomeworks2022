package ibu.edu.BubleSort;


public class IPAddress implements Comparable<IPAddress>{

	long ipFrom;
	long ipTo;
	String countryCode;
	String countryName;
	String regionName;
	String cityName;
	
	//constructor definition
	public IPAddress(long ipFrom, long ipTo, String countryCode, String countryName, String regionName, String cityName) {
		this.ipFrom = ipFrom;
		this.ipTo = ipTo;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionName = regionName;
		this.cityName = cityName;
	}
	
	//implementation of the interface's method
	@Override
	public int compareTo(IPAddress that) {
		if (this.ipFrom > that.ipFrom) {
			return 1;
		}
		else if (this.ipFrom < that.ipFrom) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	//when printing quotation marks, they are escaped with a backslash
	@Override
	public String toString() {
		return "\"" + this.ipFrom + "\"" + "," + 
				"\"" + this.ipTo + "\"" + "," + 
				"\"" + this.countryCode + "\"" + "," + 
				"\"" + this.countryName + "\"" + "," + 
				"\"" + this.regionName + "\"" + "," + 
				"\"" + this.cityName + "\"" ;
	}

}
