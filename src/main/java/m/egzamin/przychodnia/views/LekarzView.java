/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.egzamin.przychodnia.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 *
 * @author m
 */
@Route(value = "lekarze")
public class LekarzView extends VerticalLayout {

        final NavigationBar menu;
        
        public LekarzView(){
            this.menu = new NavigationBar();
            //menu.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
            add(menu);
        }
}
