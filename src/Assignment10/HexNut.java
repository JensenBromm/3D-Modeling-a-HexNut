package Assignment10;

import javax.vecmath.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;

public class HexNut extends Shape3D{
	public HexNut() {
		GeometryInfo gi=new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
		
		Point3d[] vertices=
			{
					//Create outer hexagon
					new Point3d(-0.75,1.25,0), //Point 0
					new Point3d(0.75,1.25,0),	 //Point 1
					new Point3d(1.5,0,0),  //Point 2
					new Point3d(0.75,-1.25,0), //Point 3
					new Point3d(-0.75,-1.25,0),//Point 4
					new Point3d(-1.5,0,0), //Point 5
					new Point3d(-0.75,1.25,1), //Point 6
					new Point3d(0.75,1.25,1),  //Point 7
					new Point3d(1.5,0,1),  //Point 8
					new Point3d(0.75,-1.25,1), //Point 9
					new Point3d(-0.75,-1.25,1),//Point 10
					new Point3d(-1.5,0,1), //Point 11
					
				//Create inner Circle Front Face
					new Point3d(-1,0,0), //Point 12
					new Point3d(-0.9239,0.3827,0), //Point 13
					new Point3d(-0.7071,0.7071,0), //Point 14
					new Point3d(-0.3827,0.9239,0), //Point 15
					new Point3d(0,1,0), //Point 16
					new Point3d(0.3827,0.9239,0),//Point 17
					new Point3d(0.7071,0.7071,0), //Point 18
					new Point3d(0.9239,0.3827,0),//Point 19
					new Point3d(1,0,0), //Point 20
					new Point3d(0.9239,-0.3827,0),//Point 21
					new Point3d(0.7071,-0.7071,0), //Point 22
					new Point3d(0.3827,-0.9239,0), //Point 23
					new Point3d(0,-1,0), //Point 24
					new Point3d(-0.3827,-0.9239,0), //Point 25
					new Point3d(-0.7071,-0.7071,0),//Point 26
					new Point3d(-0.9239,-0.3827,0),//Point 27
				//Create inner Circle Back Face	
					new Point3d(-1,0,1), //Point 28
					new Point3d(-0.9239,0.3827,1), //Point 29
					new Point3d(-0.7071,0.7071,1), //Point 30
					new Point3d(-0.3827,0.9239,1), //Point 31
					new Point3d(0,1,1), //Point 32
					new Point3d(0.3827,0.9239,1),//Point 33
					new Point3d(0.7071,0.7071,1), //Point 34
					new Point3d(0.9239,0.3827,1),//Point 35
					new Point3d(1,0,1), //Point 36
					new Point3d(0.9239,-0.3827,1),//Point 37
					new Point3d(0.7071,-0.7071,1), //Point 38
					new Point3d(0.3827,-0.9239,1), //Point 39
					new Point3d(0,-1,1), //Point 40
					new Point3d(-0.3827,-0.9239,1), //Point 41
					new Point3d(-0.7071,-0.7071,1),//Point 42
					new Point3d(-0.9239,-0.3827,1),//Point 43
					
			};
		
		int [] indices=
			{
				0,1,7,6,0,
				1,2,8,7,1,
				2,3,9,8,2,
				3,4,10,9,3,
				4,5,11,10,4,
				5,0,6,11,5,
				 
				
				
				//Connect Inner Circle Walls
				12,28,29,13,12,
				13,29,30,14,13,
				14,30,31,15,14,
				15,31,32,16,15,
				16,32,33,17,16,
				17,33,34,18,17,
				18,34,35,19,18,
				19,35,36,20,19,
				20,36,37,21,20,
				21,37,38,22,21,
				22,38,39,23,22,
				23,39,40,24,23,
				24,40,41,25,24,
				25,41,42,26,25,
				26,42,43,27,26,
				27,43,28,12,27,
				
				
				//fill in with panes
				5,12,13,14,15,16,0,5,
				0,16,1,0,
				1,16,17,18,19,20,2,1,
				2,20,21,22,23,24,3,2,
				3,24,4,3,
				4,24,25,26,27,12,5,4,
				
				11,28,29,30,31,32,6,11,
				6,32,7,6,
				7,32,33,34,35,36,8,7,
				8,36,37,38,39,40,9,8,
				9,40,10,9,
				10,40,41,42,43,28,11,10
				
			};
		
		gi.setCoordinates(vertices);
	    gi.setCoordinateIndices(indices);
	    
	    int[] stripCounts = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,8,4,8,8,4,8,8,4,8,8,4,8};
	    gi.setStripCounts(stripCounts);
	    NormalGenerator ng = new NormalGenerator();
	    ng.generateNormals(gi);
	    
	    gi.indexify();   

        this.setGeometry(gi.getIndexedGeometryArray());
		
		
	}
		
}
	

