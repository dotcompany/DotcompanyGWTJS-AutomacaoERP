package br.com.automacao.client.widget.grid;

import java.io.Serializable;

public class GridHeader implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String headerName;
    private String headerID;
    
    public GridHeader() {
        super();
        this.headerID = "";
        this.headerName = "";
    }
    /**
     * @param headerName
     * @param headerID
     */
    public GridHeader(String headerName, String headerID) {
        super();
        this.headerName = headerName;
        this.headerID = headerID;
    }
    public String getHeaderName() {
        return headerName;
    }
    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
    public String getHeaderID() {
        return headerID;
    }
    public void setHeaderID(String headerID) {
        this.headerID = headerID;
    }
}
