package br.com.automacao.client.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.automacao.client.DesktopApp;
import br.com.automacao.shared.util.Mirror;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class LeftToRightWidget <T extends Mirror> extends Composite implements LeftToRightMover{
  private final HorizontalPanel panel = new HorizontalPanel();
  private final MoveToWidget moveTo = new MoveToWidget(this);
  private ListBox left;
  private ListBox right;
  private LeftAccepter lAccepter;
  private String name;
  
  private Map<String, T> mapLeft;
  private Map<String, T> mapRight;
  
  public static interface LeftAccepter {    
    public boolean accept(String value);
  }
  
  public LeftToRightWidget(String leftTitle, String rightTitle){
    this(leftTitle, rightTitle, null);
  }
  
  public LeftToRightWidget(String leftTitle, String rightTitle, String style){
    this(leftTitle, rightTitle, style, new LeftToRightWidget.LeftAccepter() {
      @Override
      public boolean accept(String value) {    
        return true;
      }
    });
  }

  public LeftToRightWidget(String leftTitle, String rightTitle, String style, LeftAccepter accepter){
    initWidget(panel);
    initLayout(leftTitle, rightTitle, style);
    initClickHandlers();
    this.lAccepter = accepter;
  }

  private void initClickHandlers() {
    initializeLeftClick();
    initializeRightClick();
  }

  private void initializeRightClick() {
    right.addClickHandler(new ClickHandler(){
      boolean clicked;
      Timer timer = new Timer(){
        @Override
        public void run() {
          clicked = false;
        }
      };
      @Override
      public void onClick(ClickEvent event) {
        if (clicked)     {   
          timer.cancel();
          clicked = false;
          doubleRightClick();
        }else{
          clicked = true;        
          timer.schedule(1000);
        }
      }}    
    );    
  }

  private void initializeLeftClick() {
    left.addClickHandler(new ClickHandler(){
      boolean clicked;
      Timer timer = new Timer(){
        @Override
        public void run() {
          clicked = false;
        }
      };
      @Override
      public void onClick(ClickEvent event) {
        if (clicked)     {   
          timer.cancel();
          clicked = false;
          doubleLeftClick();
        }else{
          clicked = true;        
          timer.schedule(1000);
        }
      }}    
    );
  }
  
  private void doubleRightClick(){
    moveToLeft();
  }
  
  private void doubleLeftClick(){
    moveToRight();
  }

  public void setEnabled(boolean b) {
    if (b)
      moveTo.enable();
    else
      moveTo.disable();
  }  
  

  private void initLayout(String leftTitle, String rightTitle, String style) {
    if (style != null)
      panel.addStyleName(style);
    panel.setWidth("100%");
    Widget left = buildLeft(leftTitle); 
    panel.add(left);
    panel.setCellWidth(left, "200");
    panel.add(moveTo);
    panel.setCellHorizontalAlignment(moveTo, HasHorizontalAlignment.ALIGN_CENTER);
    panel.setCellVerticalAlignment(moveTo, HasVerticalAlignment.ALIGN_BOTTOM);
    panel.setCellWidth(moveTo, "10");
    Widget right = buildRight(rightTitle); 
    panel.add(right);
    panel.setCellWidth(right, "200");
  }
  
  private Widget buildRight(String title) {
    VerticalPanel vpanel = new VerticalPanel();
    vpanel.setWidth("100%"); vpanel.setHeight("100%");
    vpanel.add(new LabelField(title + ":"));    
    right = new ListBox(true);
    right.setVisibleItemCount(6);
    right.setWidth("100%");
    vpanel.add(right);
    mapRight = new HashMap<String, T>();
    return vpanel;
  }

  private Widget buildLeft(String leftTitle) {
    VerticalPanel vpanel = new VerticalPanel();
    vpanel.setWidth("100%"); vpanel.setHeight("100%");
    vpanel.add(new LabelField(leftTitle + ":"));
    left  = new ListBox(true);
    left.setVisibleItemCount(6);
    left.setWidth("100%");
    vpanel.add(left);
    mapLeft = new HashMap<String, T>();
    return vpanel;
  }

  public void addLeft(String value, T mirror){
    if (value == null)
      return;
    if (leftExists(value) == -1){
      left.addItem(value);
      mapLeft.put(value, mirror);
    }
    int index;
    if ((index = rightExists(value)) >= 0)
      right.removeItem(index);
  }
  
  public int leftExists(String value) {
    if (value == null)
      return -1;
    int i = 0;
    while(i < left.getItemCount() && !left.getItemText(i).equals(value))
      i++;
    return i != left.getItemCount() ? i : -1;
  }

  public int rightExists(String value) {
    if (value == null)
      return -1;
    int i = 0;
    while(i < right.getItemCount() && !right.getItemText(i).equals(value))
      i++;
    return i != right.getItemCount() ? i : -1;
  }

  public void addRight(String value, T mirror){
    if (value == null)
      return;
    if (rightExists(value) == -1){
      right.addItem(value);
      mapRight.put(value, mirror);
    }
    int index;
    if ((index = leftExists(value)) >= 0)
      left.removeItem(index);
  }

  @Override
  public void moveToLeft() {    
    if (!moveTo.isEnabled())
      return;
    for(int i = 0; i < right.getItemCount(); i++)
      if (right.isItemSelected(i)){
        String selected = right.getItemText(i);      
        if (lAccepter.accept(selected)){
           addLeft(selected, mapRight.remove(selected));
           i--;
        }
      }
    for(int i = 0; i < right.getItemCount(); ){
      String selected = right.getItemText(i);
      if (right.isItemSelected(i) && lAccepter.accept(selected))
        right.removeItem(i);
      else
        i++;
    }
    right.setSelectedIndex(-1);
    left.setSelectedIndex(-1);
  }

  @Override
  public void moveToRight() {
    if (!moveTo.isEnabled())
      return;
    for(int i = 0; i < left.getItemCount(); i++)
      if (left.isItemSelected(i)){
    	  String text = left.getItemText(i--);
    	  addRight(text, mapLeft.remove(text));
      }
    for(int i = 0; i < left.getItemCount();)
      if (left.isItemSelected(i))
        left.removeItem(i);
      else
        i++;
    right.setSelectedIndex(-1);
    left.setSelectedIndex(-1);    
  }
  
  public List<T> getSelectedRightValues(){
    List<T> values = new ArrayList<T>();
    for(T value : mapRight.values())
      values.add(value);
    return values;
  }
  
  public List<T> getSelectedLeftValues(){
    List<T> values = new ArrayList<T>();
    for(T value : mapLeft.values())
      values.add(value);
    return values;
  }
  
  public List<String> getSelectedRightNames(){
    List<String> values = new ArrayList<String>();
    for(int i = 0; i < right.getItemCount(); i++)
      values.add(right.getItemText(i));
    return values;
  }

  public void clearLeftColumns() {
    left.clear();
    mapLeft.clear();
  }
  
  public void clearRightColumns() {
    right.clear();
    mapRight.clear();
  }
  
  public void setSizeLeft(String width, String height){
    left.setSize(width, height);
  }
  
  public void setHeightLeft(String height){
    left.setHeight(height);
  }
  
  public void setWidthLeft(String width){
    left.setWidth(width);
  }
  
  public void setSizeRight(String width, String height){
    right.setSize(width, height);
  }
  
  public void setHeightRight(String height){
    right.setHeight(height);
  }
  
  public void setWidthRight(String width){
    right.setWidth(width);
  }
  
  public final void setName(String name){
    this.name = name;
  }

  public final String getName() {
    return this.name;
  }

  @Override
  public void moveAllToLeft() {
    if (!moveTo.isEnabled())
      return;
    for(int i = 0; i < right.getItemCount(); i++){
      String selected = right.getItemText(i);      
      if (lAccepter.accept(selected)){
         addLeft(selected, mapRight.remove(selected));
         i--;
      }
    }
    for(int i = 0; i < right.getItemCount(); ){
      String selected = right.getItemText(i);
      if (lAccepter.accept(selected))
        right.removeItem(i);
      else
        i++;
    }
    right.setSelectedIndex(-1);
    left.setSelectedIndex(-1);    
  }

  @Override
  public void moveAllToRight() {
    if (!moveTo.isEnabled())
      return;    
    for(int i = 0; i < left.getItemCount(); i++){
      //if (left.isItemSelected(i)){
    	String text = left.getItemText(i--);
        addRight(text, mapLeft.remove(text));
    }
    for(int i = 0; i < left.getItemCount();)
      //if (left.isItemSelected(i))
        left.removeItem(i);
      //else
        //i++;
    right.setSelectedIndex(-1);
    left.setSelectedIndex(-1);    
  }
}
interface LeftToRightMover {
  void moveToRight();
  void moveToLeft();
  void moveAllToRight();
  void moveAllToLeft();
}

final class MoveToWidget extends Composite {
  private VerticalPanel outerPanel = new VerticalPanel();  
  
  private Button toDRight = new Button(null, DesktopApp.IMG.img_dright());
  private Button toRight  = new Button(null, DesktopApp.IMG.img_right());
  private Button toLeft   = new Button(null, DesktopApp.IMG.img_left());
  private Button toDLeft  = new Button(null, DesktopApp.IMG.img_dleft());
  
  private LeftToRightMover move;
  
  public MoveToWidget(LeftToRightMover move) {
    this.move = move;
    initWidget(outerPanel);
    initLayout();
  }

  public boolean isEnabled(){
    return toRight.isEnabled();
  }
  
  public void enable() {
    toRight.enable();
    toLeft.enable();
    toDRight.enable();
    toDLeft.enable();
  }

  public void disable() {
    toRight.disable();
    toLeft.disable();
    toDRight.disable();
    toDLeft.disable();
  }

  private void initLayout() {
    outerPanel.setWidth("10");
    outerPanel.setHeight("100%");
    outerPanel.setSpacing(2);
    outerPanel.add(new Html("&nbsp;"));
    
    outerPanel.add(buildDoubleRight());
    outerPanel.setCellVerticalAlignment(toDRight, HasVerticalAlignment.ALIGN_MIDDLE);
    outerPanel.setCellHorizontalAlignment(toDRight, HasHorizontalAlignment.ALIGN_CENTER);

    
    outerPanel.add(buildRight());
    outerPanel.setCellVerticalAlignment(toRight, HasVerticalAlignment.ALIGN_MIDDLE);
    outerPanel.setCellHorizontalAlignment(toRight, HasHorizontalAlignment.ALIGN_CENTER);
    
    outerPanel.add(buildLeft());
    outerPanel.setCellVerticalAlignment(toLeft, HasVerticalAlignment.ALIGN_MIDDLE);
    outerPanel.setCellHorizontalAlignment(toLeft, HasHorizontalAlignment.ALIGN_CENTER);

    outerPanel.add(buildDoubleLeft());
    outerPanel.setCellVerticalAlignment(toDLeft, HasVerticalAlignment.ALIGN_MIDDLE);
    outerPanel.setCellHorizontalAlignment(toDLeft, HasHorizontalAlignment.ALIGN_CENTER);
    
  }

  private Button buildLeft() {
    toLeft.setTitle("Mover para esquerda.");
    toLeft.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        move.moveToLeft();
      }
    });
    return toLeft;
  }
  
  private Button buildDoubleLeft() {
    toDLeft.setTitle("Mover todos para esquerda");
    toDLeft.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        move.moveAllToLeft();
      }
    });
    return toDLeft;
  }
  
  private Button buildRight() {
    toRight = new Button(null, DesktopApp.IMG.img_right());
    toRight.setTitle("Mover para direita.");
    toRight.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        move.moveToRight();
      }
    });
    return toRight;
  }
  
  private Button buildDoubleRight() {
    toDRight.setTitle("Mover todos para direita.");
    toDRight.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        move.moveAllToRight();
      }
    });
    return toDRight;
  }  
}