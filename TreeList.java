import java.util.ArrayList;
/**
 * The TreeList class will store all the tree objects and contains a number
 * of methods that allow information to be gathered relating to these objects
 * 
 * @author Samira Mantri
 * @version Feb 9, 2017
 *
 */
public class TreeList extends ArrayList<Tree> {
	

	/**
	 * This default constructor creates an empty list
	 */
	public TreeList(){
	}
	
	/**
	 * This method acquires the total number of tree objects contained
	 * within the ArrayList
	 * 
	 * @return returns an integer that represents the total number of tree objects
	 */
	public int getTotalNumberOfTrees(){
		// create an integer variable that represents the number of trees
		// in the arraylist
		int numOfTrees=this.size();
		// return the number of trees
		return numOfTrees;

	}
	
	/**
	 * This method returns the number of tree objects in the ArrayList whose
	 * species name matches the entered species name
	 * 
	 * @param speciesName
	 * 	a string that is a particular tree species name
	 *  
	 * @return returns an integer that represents the number of matching tree 
	 * 	species in the list.
	 * 	If the species name does not exist within the list the method
	 * 	returns 0.
	 */
	public int getCountByTreeSpecies(String speciesName){
		// set a integer variable that equals the number of matches to 0
		int numOfMatches=0;
		// loop through the list and increase the number of matches every time
		// a match is found
		for (int x=0; x<this.size(); x++){
			// do this for a specific species
			if ((this.get(x)).getSpc().equalsIgnoreCase(speciesName)){
				numOfMatches++;
			}
			// do this for a more general species 
			else if ((this.get(x).getSpc()).toLowerCase().contains(speciesName.toLowerCase())){
				numOfMatches++;
			}
		}
		// return the number of matches
		return numOfMatches;
	
	}
	
	/**
	 * This method returns the number of trees that are located in a 
	 * specific borough 
	 * 
	 * @param boroName
	 * 	the boroName is a string that represents the name of the borough. 
	 * 	It must be equal to 'Manhattan','Bronx','Brooklyn','Queens', 
	 * 	or 'Staten Island'.
	 * 
	 * @return returns an integer that represents the number of trees within the specific borough.
	 * 	If the borough name is not equal to 'Manhattan','Bronx','Brooklyn',
	 * 	'Queens', or 'Staten Island,' return 0;
	 */
	public int getCountByBorough(String boroName){
		// create an integer variable that represents the number of trees in the borough. 
		// set it equal to 0.
		int treesInBoro=0;
		// if the boroName is not equal to manhattan, bronx, brooklyn, queens, or staten island
		// return 0
		if (!(boroName.equalsIgnoreCase("manhattan"))&&!(boroName.equalsIgnoreCase("bronx"))&&!
			(boroName.equalsIgnoreCase("brooklyn"))&&!(boroName.equalsIgnoreCase("queens"))
			&&!(boroName.equalsIgnoreCase("staten island"))){
			return 0;
		}
		// iterate through the list and determine how many trees exist within the specified borough
		for (int x=0; x<this.size(); x++){
			if (((this.get(x)).getBoro()).equalsIgnoreCase(boroName)){
				// if a tree exists within the borough increase treesInBoro 
				treesInBoro++;
			}
		}
		// return of the amount of trees in the borough
		return treesInBoro;
	}
	
	/**
	 * This method obtains the number of a specific species of trees that exists
	 * within a specified borough
	 * 
	 * @param speciesName
	 * 	the speciesName is the species of a tree. It should already exist within 
	 * 	the list
	 * 
	 * @param boroName
	 * 	the boroName is the name of the borough. It must be equal to 'Manhattan',
	 * 	'Bronx','Brooklyn','Queens', or 'Staten Island'. 
	 * 
	 * @return returns the number of a specific species of tree that exists within 
	 * 	a specified borough. If the species does not exist within the list or the 
	 * 	borough does not exist within NYC return 0.
	 */
	public int getCountByTreeSpeciesBorough(String speciesName, String boroName){
		// if the boroName does not equals a borough in NYC return 0
		if (!(boroName.equalsIgnoreCase("manhattan"))&&!(boroName.equalsIgnoreCase("bronx"))
			&&!(boroName.equalsIgnoreCase("brooklyn"))&&!(boroName.equalsIgnoreCase("queens"))
			&&!(boroName.equalsIgnoreCase("staten island"))){
			return 0;
		}
		
		// create a counter to check whether the entered speciesName exists in the treeList
		int speciesInList=0;
		String lowercaseSpc= speciesName.toLowerCase();
		for (int x=0; x<this.size(); x++){
			if ((this.get(x).getSpc()).equalsIgnoreCase(speciesName)){
				// if the speciesName is in the treeList, increase the speciesInList
				speciesInList++;
			}
			else{
				String treeInListSpc= ((this.get(x)).getSpc()).toLowerCase();
				if ((treeInListSpc.contains(lowercaseSpc))){
					// if the speciesName is in the treeList, increase the speciesInList
					speciesInList++;
				}
			}

		}
		// if no trees with the entered speciesName exist in the treeList return 0
		if (speciesInList==0){
			return 0;
		}
		
		// if the boroName and speciesName is valid, create a integer variable that is initially
		// equal to 0. It will count the number of the particular species that exists 
		// within the given borough
		int treesInBoro=0;
		for (int x=0; x<this.size();x++){
			// if a specific species exists within a borough increase the treesInBoro by 1
			if ((((this.get(x)).getSpc()).equalsIgnoreCase(speciesName)&&
				((this.get(x)).getBoro()).equalsIgnoreCase(boroName))){
				treesInBoro++;
			}
			// if a more general species exists within a borough increase the treesInBoro by 1
			else if ((((this.get(x)).getSpc()).toLowerCase()).contains(speciesName.toLowerCase())
					&&((this.get(x)).getBoro()).equalsIgnoreCase(boroName)){
				treesInBoro++;
			}
		}
		// return the number of a specific species of tree that is in the borough
		return treesInBoro;
		
	}
	
	/**
	 * This method creates an ArrayList of tree species strings that 
	 * match the species string sent to the method
	 * 
	 * @param speciesName
	 * 	the speciesName is the name of the entered tree species
	 * 
	 * @return returns a list of the matching tree species names
	 */
	public ArrayList<String> getMatchingSpecies(String speciesName){
		// create an ArrayList that will contain tree species strings
		ArrayList<String> treesInSpc= new ArrayList<String>();
		
		// make the species lower case to allow for case insensitivity
		String lowercaseSpc= speciesName.toLowerCase();
		
		// loop through the list to determine matching species 
		for (int x=0; x<this.size(); x++){
			String specificTreeSpc= (this.get(x)).getSpc();
			String specificTreeLower= (specificTreeSpc).toLowerCase();
			// if a specific species is found, return it as the only string
			// that matches
			if (specificTreeSpc.equalsIgnoreCase(speciesName)){
				treesInSpc.add(specificTreeSpc);
				return treesInSpc;
			}
			// if the speciesName is a more general species, add any matching
			// species to the treesInSpc list
			else if ((specificTreeLower.contains(lowercaseSpc))){
				if (!(treesInSpc.contains(specificTreeSpc))){
					treesInSpc.add(specificTreeSpc);
				}
			}
		}
		// return the matching species ArrayList
		return treesInSpc;
	}
	
	/**
	 * This method overrides the toString method of object in order to create 
	 * a string that contains all the trees in the list and their information
	 * 
	 * @return the method returns a string representation of the all
	 * 	the trees in the list and their information
	 */
	@Override
	public String toString(){
		// create a string to hold the information of all the trees
		String treeList="";
		
		// loop through the list to gain the info of all the tree objects
		for (int x=0; x<this.size();x++){
			Tree treeObject=(this.get(x));
			treeList+=(treeObject.getSpc()).toUpperCase()+"\n";
			treeList+="Tree ID: "+(treeObject.getId())+"\n";
			treeList+="Tree Diameter: "+(treeObject.getDiam())+"\n";
			treeList+="Tree Status: "+(treeObject.getStatus())+"\n";
			treeList+="Tree Health: "+(treeObject.getHealth())+"\n";
			treeList+="Tree Zipcode: "+String.format("%05d", (treeObject.getZip()))+"\n";
			treeList+="Tree Boroname: "+(treeObject.getBoro())+"\n";
			treeList+="Tree X Coordinate: "+(treeObject.getX())+"\n";
			treeList+="Tree Y Coordinate: "+(treeObject.getY())+"\n";
			treeList+="\n";
			
		}
		// return the string containing all the information
		return treeList;
	}
	

	


}
