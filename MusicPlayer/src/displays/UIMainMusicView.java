package displays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import objects.TuneManager;
import widgets.TuneWidget;

public class UIMainMusicView {

public void createComposite(Display display, TuneManager manager){
		
		Color red = display.getSystemColor(SWT.COLOR_RED);
	      Color blue = display.getSystemColor(SWT.COLOR_BLUE);
	      Shell shell = new Shell (display);
	      shell.setLayout(new FillLayout());
	        
	      final ScrolledComposite sc1 = new ScrolledComposite(shell, SWT.H_SCROLL | SWT.V_SCROLL);
	      sc1.setExpandHorizontal(true);
	      sc1.setExpandVertical(true);
	      final Composite c1 = new Composite(sc1, SWT.NONE);
	      sc1.setContent(c1);
	      c1.setBackground(blue);
	      GridLayout layout = new GridLayout();
	      layout.numColumns = 2;
	      c1.setLayout(layout);
	
	      for (int tuneNumber = 0; tuneNumber < manager.getTunes().size(); tuneNumber++) {
        	
	    	  TuneWidget taskWidget = new TuneWidget(manager.getTunes().get(tuneNumber), manager);
	          taskWidget.createComposite(c1);
	      }
		      
	      sc1.setMinSize(c1.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		      
	
	      shell.open();
	      while (!shell.isDisposed ()) {
	          if (!display.readAndDispatch ()) display.sleep ();
	      }
	      display.dispose ();
	}
	
	
}
