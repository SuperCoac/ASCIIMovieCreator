package Film;

import java.util.LinkedList;
import java.util.Objects;




/**
 * Une Image est un ensemble d'éléments. Chaque éléments peut
 * être placé à des profondeurs différents. Une image possède
 * une largeur et une longueur.
 * L'élément qui a une profondeur
 * plus haute va écraser les éléments qui
 * ont une profondeur plus faible si jamais il y a
 * des caractères à une même position. 
 * 
 * @author  Le Victor
 * @author  Luttgens Pascal
 * @see IElément
 * @version 1.0
 * @since   1.0
 **/
public class Image implements Cloneable {
	
	private LinkedList<IElément> éléments = new LinkedList<IElément>();
	
	private int x;
	private int y;
	
	
    /**
    * Construit une Image vide de taille x,y
    *
    * @param x			la largeur
    * @param y			la longueur
    * @since   1.0
    */
	public Image(int x, int y) {
		assert(x > 0 && y > 0);
		this.x = x;
		this.y = y;
	}
	
    /**
    * Construit une Image à partir d'une autre
    *
    * @param image			l'image a copiée
    * @since   1.0
    */
    public Image(Image image) {
		this.x = image.x;
		this.y = image.y;
		for (int i = 0; i < image.size(); i++) {
			éléments.add(i, image.get(i).clone());
		}
	}

    
	/**
     * Retourne l'élément de profondeur i
     *
     * @param	la profondeur
     * @return	l'élément
     * @since   1.0
     */
    public IElément get(int i) {
		return éléments.get(i);
	}

	/**
    * Retourne le nombre d'éléments dans l'image
    *
    * @return	le nombre d'élément
    * @since   1.0
    */
	public int size() {
		return éléments.size();
	}

	/**
    * Retourne la largeur de l'image
    *
    * @return			la largeur
    * @since   1.0
    */
	public int getX() {
		return x;
	}

    /**
    * Retourne la longueur de l'image 
    *
    * @return			la longueur
    * @since   1.0
    */
	public int getY() {
		return y;
	}
	
	
    /**
    * Ajoute un élément dans l'image à
    * une certaine profondeur
    *
    * @param élément			l'élément
    * @param profondeur			la profondeur
    * @since   1.0
    */
	public void add(IElément élément, int profondeur) {
		assert(profondeur > 0 && profondeur < éléments.size());
		éléments.add(profondeur,élément);
	}
	
    /**
    * Ajoute un élément dans l'image à
    * la profondeur la plus haute
    *
    * @param élément			l'élément
    * @since   1.0
    */
	public void add(IElément élément) {
		éléments.add(élément);
	}
	
    /** Supprime un élément dans l'image 
*/
        public void supprimer(int indice) {
            éléments.remove(indice);
        }
        
        public void supprimer(IElément élément) {
            éléments.remove(élément);
        }
	
    /**
    * Renvoie un String qui correspond à
    * correspond à l'Image en respectant les 
    * profondeurs des éléments. 
    *
    * @return 	le String
    * @since   1.0
    */
	@Override
	public String toString() {
		
		// Initialisation du tableau de char
		char tab[][] = new char[x][y];
	    for (int i = 0; i < tab.length; i++)
	    	for (int j = 0; j < tab[i].length; j++)
	    		tab[i][j] = ' ';
		
	    // On rentre chaque éléments dans le tableau de char
	    for(IElément élément: éléments) {
	    	for (int i = 0; i < élément.size(); i++) {
	    		if(x >= élément.get(i).getCoord().getX() && y >= élément.get(i).getCoord().getY()
	    				&& élément.get(i).getCoord().getX() >= 0 && élément.get(i).getCoord().getY() >=0 )
				tab[élément.get(i).getCoord().getX()][élément.get(i).getCoord().getY()] = élément.get(i).getCaractère();
			}
	    }
	    
	    String s = new String("");
	    for (int j = 0; j < tab[0].length; j++) {
	    	for (int i = 0; i < tab.length; i++) {
	    	
	    		s+=tab[i][j];
	    	}
	    	s += "\n";
	    }
	    	
	    return s;
		
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.éléments);
        hash = 37 * hash + this.x;
        hash = 37 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Image other = (Image) obj;
        if (!Objects.equals(this.éléments, other.éléments)) {
            return false;
        }
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
        
        
        
        @Override
        public Image clone() {
            return new Image(this);
        }
        
	
	

}
