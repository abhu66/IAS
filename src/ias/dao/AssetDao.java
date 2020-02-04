/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.dao;

import ias.models.Asset;
import ias.view.FormEditAsset;
import ias.view.FormNewAsset;
import java.util.List;

/**
 *
 * @author asyst
 */
public interface AssetDao {
    public void addNewAsset(Asset asset,FormNewAsset formNewAsset);
    public List<Asset> getAllAsset(String param);
    public Asset finByCode(String code);
    public void saveOnEdit(Asset asset, FormEditAsset formEditAsset);
}
