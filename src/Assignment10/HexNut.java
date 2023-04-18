package Assignment10;

import javax.vecmath.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;


public class HexNut extends Shape3D{
	public HexNut() {
		GeometryInfo gi=new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
		
		Point3d[] vertices=
			{
					//Create outer hexagon
					new Point3d(-1,1,0), //Point 0
					new Point3d(1,1,0),	 //Point 1
					new Point3d(2,0,0),  //Point 2
					new Point3d(1,-1,0), //Point 3
					new Point3d(-1,-1,0),//Point 4
					new Point3d(-2,0,0), //Point 5
					new Point3d(-1,1,1), //Point 6
					new Point3d(1,1,1),  //Point 7
					new Point3d(2,0,1),  //Point 8
					new Point3d(1,-1,1), //Point 9
					new Point3d(-1,-1,1),//Point 10
					new Point3d(-2,0,1), //Point 11
					
					//Create two inner hexagons (Supposed to be circles but i cant figure it out)
					new Point3d(-1,0,0), //Point 12
					new Point3d(-0.5,0.5,0),//Point 13
					new Point3d(0.5,0.5,0),//Point 14
					new Point3d(1,0,0),//Point 15
					new Point3d(0.5,-0.5,0),//Point 16
					new Point3d(-0.5,-0.5,0),//Point 17
					
					new Point3d(-1,0,1), //Point 18
					new Point3d(-0.5,0.5,1),//Point 19
					new Point3d(0.5,0.5,1),//Point 20
					new Point3d(1,0,1),//Point 21
					new Point3d(0.5,-0.5,1),//Point 22
					new Point3d(-0.5,-0.5,1),//Point 23
			};
		
		int [] indices=
			{
				0,1,7,6,0,
				1,2,8,7,1,
				2,3,9,8,2,
				3,4,10,9,3,
				4,5,11,10,4,
				5,0,6,11,5,
				 
				//Outline inner hexagon
				13,14,20,19,13,
				14,15,21,20,14,
				15,16,22,21,15,
				16,17,23,22,16,
				17,12,18,23,17,
				12,13,18,19,12,
				
				
				//Fill In gaps
				5,17,12,0,5,13,
				0,13,14,1,0,
				1,14,15,2,1,
				2,15,16,3,2,
				2,16,17,5,4,3,2,
				
				11,23,18,6,11,19,
				6,19,20,7,6,
				7,20,21,8,7,
				8,21,22,9,8,
				8,22,23,11,10,9,8,
				
			};
		
		gi.setCoordinates(vertices);
	    gi.setCoordinateIndices(indices);
	    
	    int[] stripCounts = {5,5,5,5,5,5,5,5,5,5,5,5,6,5,5,5,7,6,5,5,5,7};
	    gi.setStripCounts(stripCounts);
	    NormalGenerator ng = new NormalGenerator();
	    ng.generateNormals(gi);
	    
	    gi.indexify();   

        this.setGeometry(gi.getIndexedGeometryArray());
		
		
	}
		
}
	

