import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eric Scagnelli on 12/4/16.
 * 
 * This class is the form that will be displayed for any operation requiring only a classid
 * User data is collected into the text field.  When the OK button is pressed it's listener's
 * method will be called.
 */
public class ClassIDForm extends JPanel {

    private JLabel classidLabel;
    private JTextField classidField;
    private JButton okBtn;

    private ClassIDFormListener classIDFormListener;
    public ClassIDForm(){

        classidLabel = new JLabel("ClassID: ");
        classidField = new JTextField(10);
        okBtn = new JButton("OK");

        okBtn.addActionListener(new ActionListener() {
			//On button press, send information to MainFrame
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!classidField.getText().isEmpty())
                    classIDFormListener.sendClassID(classidField.getText());
            }
        });

        GridBagConstraints gc = new GridBagConstraints();       //put labesl and text fields into panel
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 10;
        gc.weighty = 10;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,0);

        add(classidLabel, gc);

        gc.gridx = 1;
        add(classidField, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.weighty = 1;
        gc.weightx = 1;
        add(okBtn,gc);
    }

    public void setCLassIDListener(ClassIDFormListener listener){
        classIDFormListener = listener;
    }

    public void clearTextField(){
        classidField.setText(null);
    }
}

