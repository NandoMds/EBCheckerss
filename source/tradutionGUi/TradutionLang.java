package tradutionGUi;

import java.util.Locale;
import java.util.ResourceBundle;

public class TradutionLang {
	
	private String nameLang;
	
	private boolean isSelect;

	public TradutionLang(String lang) {
		this.setNameLang(lang);
		
		this.getBundle(lang);
	}
	
	public ResourceBundle getBundle(String locale) {
		switch (locale) {
		case "pt": {
			return ResourceBundle.getBundle("tradutionGUi/Tradution", new Locale("pt","BR"));
		}
		case "en": {
			return ResourceBundle.getBundle("tradutionGUi/Tradution", new Locale("en","USA"));
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + locale);
		}
	}

	public String getNameLang() {
		return nameLang;
	}



	public void setNameLang(String lang) {
		this.nameLang = lang;
	}



	public boolean getIsSelect() {
		return isSelect;
	}



	public void setIsSelect(boolean select) {
		this.isSelect = select;
	}

}
