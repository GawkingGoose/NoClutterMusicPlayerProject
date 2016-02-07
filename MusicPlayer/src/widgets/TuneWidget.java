package widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import objects.Tune;
import objects.TuneManager;
import objects.TunePlayer;
import utils.PlayerFactory;

public class TuneWidget {

	private Tune linkedTune;
	private TuneManager tuneManager;
	
	public TuneWidget(Tune tune, TuneManager manager){
		this.linkedTune = tune;
		this.tuneManager = manager;
	}
	
	public void update(){
		//? - this needs to refresh the widgets sizes? but maybe thats the wrong way to go about it - maybe you should only be able to edit a tasks details when you open it
	}
	
	public void createComposite(Composite parent){
		
		Composite compositeMain = new Composite(parent, SWT.NORMAL);
		
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 1;
        compositeMain.setLayout(rowLayout);

        Group group = new Group(compositeMain, SWT.NONE);
        group.setText("Tune " + linkedTune.getId());
        group.setLayout(new RowLayout(SWT.VERTICAL));
        
        Text name = new Text(group, SWT.NORMAL | SWT.WRAP | SWT.READ_ONLY);
        name.setText(linkedTune.getName());
        
        Button buttonPlay = new Button(compositeMain, SWT.NONE);
        buttonPlay.setText("Play/Select");
        buttonPlay.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				tuneManager.playTune(linkedTune);
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
        
//      compositeMain.setSize(compositeMain.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        compositeMain.pack();
		
	}
	
	
}
