package es.ulpgc.eite.da.orderingitems.items;

import es.ulpgc.eite.da.orderingitems.app.AppMediator;
import es.ulpgc.eite.da.orderingitems.app.DetailToListState;
import es.ulpgc.eite.da.orderingitems.app.ListToDetailState;

public class ItemListRouter implements ItemListContract.Router {

  public static String TAG = ItemListRouter.class.getSimpleName();

  private AppMediator mediator;

  public ItemListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public DetailToListState getStateFromNextScreen() {
    return mediator.getDetailToListState();
  }

  @Override
  public void passStateToNextScreen(ListToDetailState state) {
    mediator.setListToDetailState(state);
  }


}
