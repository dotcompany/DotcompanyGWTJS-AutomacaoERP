package br.com.automacao.client.widget.plugin;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentPlugin;

public class InformationPlugin implements ComponentPlugin {

//	private WidgetComponent infoIcon;
	
	@Override
	public void init(Component component) {
		
	}
//    private boolean rendered;
//    private String text;
//    private WidgetComponent infoIcon;
//
//    public InformationPlugin(String text) {
//        this.text = text;
//    }
//
//    public void init(final Component component) {
//
//      component.addListener(Events.Resize, new Listener<BoxComponentEvent>() {
//
//        public void handleEvent(BoxComponentEvent ce) {
//          boolean state = ce.getComponent().isDisabledEvents();
//          ce.getComponent().disableEvents(true);
//          ce.getBoxComponent().setWidth(ce.getWidth());//-20
//          ce.getComponent().disableEvents(state);
//          if (!rendered) {
//              if(infoIcon==null){
//				 Image image = new Image("images/img_add.png");
//                infoIcon = new WidgetComponent(DesktopApp.IMG.information().createImage());
//                Element p = component.el().getParent().dom;
//                infoIcon.render(p);
//                infoIcon.setHideMode(HideMode.VISIBILITY);
//                infoIcon.hide();
//                infoIcon.setStyleAttribute("display", "block");
//                infoIcon.el().makePositionable(true);
//              }
//              else
//                  if (!infoIcon.el().isConnected()) {
//                    Element p = component.el().getParent().dom;
//                    p.appendChild(infoIcon.getElement());
//                  }
//
//            if (!infoIcon.isAttached())
//                ComponentHelper.doAttach(infoIcon);
//
//            DeferredCommand.addCommand(new Command() {
//                public void execute() {
//                    infoIcon.el().alignTo(component.getElement(), "tl-tr", new int[] {2, 3});
//                }
//            });
//
//            if (GXT.isIE || GXT.isOpera){
//                DeferredCommand.addCommand(new Command() {
//                    public void execute() {
//                        infoIcon.el().alignTo(component.getElement(), "tl-tr", new int[] {2, 3});
//                    }
//                });
//            }
//
//            // needed to prevent flickering
//              DeferredCommand.addCommand(new Command() {
//                public void execute() {
//                  if (infoIcon.isAttached()) {
//                    infoIcon.show();
//                  }
//                }
//              });
//              infoIcon.setToolTip(text);
//              infoIcon.getToolTip().addStyleName("x-form-invalid-tip");
//
//              component.el().repaint();
//            rendered = true;
//          }
//        }
//
//      });
//    }
    
}
