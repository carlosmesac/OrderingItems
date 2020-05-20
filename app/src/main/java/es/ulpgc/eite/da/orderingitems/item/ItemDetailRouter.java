package es.ulpgc.eite.da.orderingitems.item;


import es.ulpgc.eite.da.orderingitems.app.AppMediator;
import es.ulpgc.eite.da.orderingitems.app.DetailToListState;
import es.ulpgc.eite.da.orderingitems.app.ListToDetailState;

public class ItemDetailRouter implements ItemDetailContract.Router {

  public static String TAG = ItemDetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public ItemDetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public void passStateToPreviousScreen(DetailToListState state) {
    mediator.setDetailToListState(state);
  }

  @Override
  public ListToDetailState getStateFromPreviousScreen() {
    return mediator.getListToDetailState();
  }

}
