package Assignment10;

import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import java.applet.*;
import com.sun.j3d.utils.applet.MainFrame;

public class assignment10 extends Applet {

    public static void main(String[] args) {
    	//Set no erase background
        new MainFrame(new assignment10(), 650, 480);
    }

    public void init() {
        // create 4 Canvas3D objects
        this.setLayout(new GridLayout(1,2));
        GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
        // Create the standard view but dont add it
        Canvas3D cv = new Canvas3D(gc);    
        SimpleUniverse su = new SimpleUniverse(cv);
        su.getViewingPlatform().setNominalViewingTransform();
        
        
        /*
         * First View:
         * Located at: 0,0,1
         * Looking at:0,0,0
         * +Y is up direction
         */
        cv = new Canvas3D(gc);
        add(cv);
        BranchGroup bgView = createView(cv, new Point3d(0,0,1), 
          new Point3d(0,0,0), new Vector3d(0,1,0));
        su.addBranchGraph(bgView);
        /*
         * Second View:
         * Located at: 1,1,1
         * Looking at:0,0,0
         * +X is up direction
         */
        cv = new Canvas3D(gc);
        add(cv);
        bgView = createView(cv, new Point3d(1, 1, 1),
          new Point3d(0,0,0), new Vector3d(1,0,0));
        su.addBranchGraph(bgView);
        
        // content branch
        BranchGroup bg = createSceneGraph();
        bg.compile();
        su.addBranchGraph(bg);
      }

        private BranchGroup createView(Canvas3D cv, Point3d eye, Point3d center, Vector3d vup) {
        	    View view = new View();
        	    //Set Specified FOV and clip distance
        	    view.setFieldOfView(0.04 * Math.PI);
        	    view.setFrontClipDistance(0.01);
        	    
        	    view.setProjectionPolicy(View.PARALLEL_PROJECTION);
        	    ViewPlatform vp = new ViewPlatform();
        	    view.addCanvas3D(cv);
        	    view.attachViewPlatform(vp);
        	    view.setPhysicalBody(new PhysicalBody());
        	    view.setPhysicalEnvironment(new PhysicalEnvironment());
        	    Transform3D trans = new Transform3D();
        	    trans.lookAt(eye, center, vup);
        	    trans.invert();
        	    TransformGroup tg = new TransformGroup(trans);
        	    tg.addChild(vp);
        	    BranchGroup bgView = new BranchGroup();
        	    bgView.addChild(tg);
        	    return bgView;
        	  }
	  
	 private static BranchGroup createSceneGraph() {
		 
		 BranchGroup root = new BranchGroup();
		    TransformGroup spin = new TransformGroup();
		    spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		    root.addChild(spin);
			// object
			Appearance ap = new Appearance();
			 ap.setMaterial(new Material());
		        PolygonAttributes pa = new PolygonAttributes();
		        pa.setBackFaceNormalFlip(true);
		        pa.setCullFace(PolygonAttributes.CULL_NONE);
		        ap.setPolygonAttributes(pa);
			//Turn BackFace Normal
			Material m=new Material();
	        m.setAmbientColor(0.5f, 0.5f, 0.5f);
			ap.setMaterial(m);
			Shape3D shape = new HexNut();
			shape.setAppearance(ap);
			Transform3D tr = new Transform3D();
			tr.setScale(0.15);
			TransformGroup tg = new TransformGroup(tr);
			 spin.addChild(tg);
			 tg.addChild(shape);
			
			// rotator
		    Alpha alpha = new Alpha(-1, 24000);
		    RotationInterpolator rotator = new RotationInterpolator(alpha, spin);
		    BoundingSphere bounds = new BoundingSphere();
		    rotator.setSchedulingBounds(bounds);
		    spin.addChild(rotator);
			// background and light
			Background background = new Background(1.0f, 1.0f, 1.0f);
			background.setApplicationBounds(bounds);
			root.addChild(background);
			AmbientLight light = new AmbientLight(true, new Color3f(Color.black));
			light.setInfluencingBounds(bounds);
			root.addChild(light);
			PointLight ptlight = new PointLight(new Color3f(Color.gray), new Point3f(1f, 1f,1f), new Point3f(1f, 0f, 0f));
			ptlight.setInfluencingBounds(bounds);
			root.addChild(ptlight);
			PointLight ptlight2 = new PointLight(new Color3f(Color.gray), new Point3f(-2f, 2f, 2f), new Point3f(1f, 0f, 0f));
			ptlight2.setInfluencingBounds(bounds);
			root.addChild(ptlight2);
			return root;
		}

}
