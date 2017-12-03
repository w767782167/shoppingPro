package lwd.entity;

public class kind {
	private Long id;
	private String bigName;
	public kind(Long id, String bigName) {
		super();
		this.id = id;
		this.bigName = bigName;
	}
	public kind() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getbigName() {
		return bigName;
	}
	public void setbigName(String bigName) {
		this.bigName = bigName;
	}
	@Override
	public String toString() {
		return "kind [id=" + id + ", bigName=" + bigName + "]";
	}
	

}
