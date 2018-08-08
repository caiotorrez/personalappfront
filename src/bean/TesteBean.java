package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class TesteBean implements Serializable {
	
	
	private String txt1;

	public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add("i1");
        }
         
        return results;
    }

	public String getTxt1() {
		return txt1;
	}
	
	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}
}
