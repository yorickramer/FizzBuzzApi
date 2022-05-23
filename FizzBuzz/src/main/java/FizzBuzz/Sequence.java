package FizzBuzz;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sequence")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Sequence {

	@XmlElement(name = "sequence", type = String.class)
	private List<String> sequence;

    public Sequence() {
    	sequence = new ArrayList<>();
    }
    
    public Sequence(List<String> s) {
    	this.sequence = new ArrayList<>(s);
    }
    
    public List<String> getSequence() {
		return sequence;
	}
	
	public void setSequence(List<String> s) {
		this.sequence = s;
	}
}
