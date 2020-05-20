package es.ulpgc.eite.da.orderingitems.app;

import java.util.Objects;

import es.ulpgc.eite.da.orderingitems.data.ItemData;

public class ListToDetailState {

    public ItemData data;

    public ListToDetailState(ItemData data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ListToDetailState that = (ListToDetailState) obj;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "counterData: " + data;
    }
}
