package com.example.retrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubResponse {
    @Expose
    @SerializedName("total_count")
    private int totalCount;
    @Expose
    @SerializedName("incomplete_results")
    private boolean incompleteResults;
    @Expose
    @SerializedName("items")
    private List<Item> items;

    public GithubResponse(int totalCount, boolean incompleteResults, List<Item> items) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
