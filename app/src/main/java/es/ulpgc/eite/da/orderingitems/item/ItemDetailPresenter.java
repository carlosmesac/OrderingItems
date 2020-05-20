package es.ulpgc.eite.da.orderingitems.item;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.orderingitems.app.DetailToListState;
import es.ulpgc.eite.da.orderingitems.app.ListToDetailState;

public class ItemDetailPresenter implements ItemDetailContract.Presenter {

  public static String TAG = ItemDetailPresenter.class.getSimpleName();

  private WeakReference<ItemDetailContract.View> view;
  private ItemDetailState state;
  private ItemDetailContract.Model model;
  private ItemDetailContract.Router router;

  public ItemDetailPresenter(ItemDetailState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new ItemDetailState();
    }

    ListToDetailState savedState = router.getStateFromPreviousScreen();
    if(savedState != null){
      state.data = savedState.data;
      state.listSize = savedState.size;
    }
    view.get().onDataUpdated(state);
    state.numOfClicks=0;

  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    model.onRestartScreen(state.data,state.listSize);

    view.get().onDataUpdated(state);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    model.onDataFromPreviousScreen(state.data,state.listSize);
    //TODO: falta implementacion
  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");

    DetailToListState detailToListState = new DetailToListState(state.numOfClicks,state.data);
    router.passStateToPreviousScreen(detailToListState);
    //TODO: falta implementacion
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onButtonTapped() {
    // Log.e(TAG, "onButtonTapped()");
    model.onIncrPosition();
    state.data =model.getStoredData();
    state.numOfClicks++;
    view.get().onDataUpdated(state);
    //TODO: falta implementacion
  }

  @Override
  public void injectView(WeakReference<ItemDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ItemDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ItemDetailContract.Router router) {
    this.router = router;
  }
}
