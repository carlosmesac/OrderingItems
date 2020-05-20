package es.ulpgc.eite.da.orderingitems.app;

import java.util.Objects;

import es.ulpgc.eite.da.orderingitems.data.ItemData;

public class DetailToListState {

    public ItemData itemData;
    public Integer numClicks;

    public DetailToListState(Integer numClicks, ItemData itemData) {
        this.itemData = itemData;
        this.numClicks = numClicks;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DetailToListState that = (DetailToListState) obj;
        return Objects.equals(numClicks, that.numClicks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numClicks);
    }

    @Override
    public String toString() {
        return "counterData: " + numClicks;
    }
}
