package it.objectmethod.webapp.todo.models;

public class Activity {
	public String description;
	public boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}
