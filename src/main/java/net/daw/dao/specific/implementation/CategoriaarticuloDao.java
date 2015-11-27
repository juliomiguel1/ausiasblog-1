/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 * AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/openAUSIAS
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */
package net.daw.dao.specific.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import net.daw.bean.specific.implementation.CategoriaarticuloBean;
import net.daw.bean.specific.implementation.UsuarioBean;
import net.daw.dao.generic.implementation.TableDaoGenImpl;
import net.daw.helper.statics.FilterBeanHelper;
import net.daw.helper.statics.SqlBuilder;

/**
 *
 * @author a022583461z
 */
public class CategoriaarticuloDao extends TableDaoGenImpl<CategoriaarticuloBean> {

    public CategoriaarticuloDao(Connection pooledConnection) throws Exception {
        super(pooledConnection);
    }

    @Override
    public CategoriaarticuloBean get(CategoriaarticuloBean oCategoriaArticuloBean, Integer expand) throws Exception {
        if (oCategoriaArticuloBean.getId() > 0) {
            if (oMysql.existsOne(strSqlSelectDataOrigin, oCategoriaArticuloBean.getId())) {
                oCategoriaArticuloBean.setNombre(oMysql.getOne(strSqlSelectDataOrigin, "nombre", oCategoriaArticuloBean.getId()));
                oCategoriaArticuloBean.setDescripcion(oMysql.getOne(strSqlSelectDataOrigin, "descripcion", oCategoriaArticuloBean.getId()));
            }
        }
        return oCategoriaArticuloBean;
    }

    @Override
    public ArrayList<CategoriaarticuloBean> getAll(ArrayList<FilterBeanHelper> alFilter, HashMap<String, String> hmOrder) throws Exception {
        strSqlSelectDataOrigin += SqlBuilder.buildSqlWhere(alFilter);
        strSqlSelectDataOrigin += SqlBuilder.buildSqlOrder(hmOrder);
        ResultSet oResultset = oMysql.getAllSql(strSqlSelectDataOrigin);
        ArrayList<CategoriaarticuloBean> alCategorias = new ArrayList<>();
        while (oResultset.next()) {
            int id = oResultset.getInt("id");
            CategoriaarticuloBean oCategoriaArticuloBean = new CategoriaarticuloBean();
            oCategoriaArticuloBean.setId(id);
            oCategoriaArticuloBean.setNombre(oMysql.getOne(strSqlSelectDataOrigin, "nombre", id));
            oCategoriaArticuloBean.setDescripcion(oMysql.getOne(strSqlSelectDataOrigin, "descripcion", id));
            alCategorias.add(oCategoriaArticuloBean);
        }
        return alCategorias;
    }

    public int getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
        strSqlSelectDataOrigin += SqlBuilder.buildSqlWhere(alFilter);
        return oMysql.getCount(strSqlSelectDataOrigin);

    }

    @Override
    public ArrayList<CategoriaarticuloBean> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBeanHelper> alFilter, HashMap<String, String> hmOrder) throws Exception {
        strSqlSelectDataOrigin += SqlBuilder.buildSqlWhere(alFilter);
        strSqlSelectDataOrigin += SqlBuilder.buildSqlOrder(hmOrder);
        ResultSet oResultset = oMysql.getPage(strSqlSelectDataOrigin, intRegsPerPag, intPage);
        ArrayList<CategoriaarticuloBean> alCategorias = new ArrayList<>();
        while (oResultset.next()) {
            int id = oResultset.getInt("id");
            CategoriaarticuloBean oCategoriaArticuloBean = new CategoriaarticuloBean();
            oCategoriaArticuloBean.setId(id);
            oCategoriaArticuloBean.setNombre(oMysql.getOne(strSqlSelectDataOrigin, "nombre", id));
            oCategoriaArticuloBean.setDescripcion(oMysql.getOne(strSqlSelectDataOrigin, "descripcion", id));
            alCategorias.add(oCategoriaArticuloBean);
        }
        return alCategorias;
    }

    @Override
    public int getPages(int intRegsPerPag, ArrayList<FilterBeanHelper> alFilter) throws Exception {
        strSqlSelectDataOrigin += SqlBuilder.buildSqlWhere(alFilter);
        return oMysql.getPages(strSqlSelectDataOrigin, intRegsPerPag);
    }

    @Override
    public CategoriaarticuloBean set(CategoriaarticuloBean oCategoriaArticuloBean) throws Exception {
        if (oCategoriaArticuloBean.getId() == 0) {
            oCategoriaArticuloBean.setId(oMysql.insertOne(strTableOrigin));
        }
        oMysql.updateOne(oCategoriaArticuloBean.getId(), strTableOrigin, "nombre", oCategoriaArticuloBean.getNombre());
        oMysql.updateOne(oCategoriaArticuloBean.getId(), strTableOrigin, "descripcion", oCategoriaArticuloBean.getDescripcion());
        return oCategoriaArticuloBean;
    }

    @Override
    public int remove(CategoriaarticuloBean oCategoriaArticuloBean) throws Exception {
        return oMysql.removeOne(oCategoriaArticuloBean.getId(), strTableOrigin);
    }

}
