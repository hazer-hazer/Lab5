package collection;

import comps.HumanBeing;
import comps.HumanBeingDTO;
import utils.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class Collection {
    private ArrayList <HumanBeing> col;
    private Date creationDate;

    public Collection(HumanBeingDTO[] arr_col){
        creationDate = new Date();
        col = new ArrayList<>();
        for(HumanBeingDTO dto : arr_col){
            dto.validateFields();
            add(dto.toHumanBeing());
        }
    }

    /**
     * set
     * set collection by List-interface
     * */
    public void set(List col){
        col = new ArrayList<HumanBeing>(col);
    }

    /**
     * asArray
     * @return Collection as Object array
     * */
    public Object[] asArray(){
        return col.toArray();
    }

    /**
     * asDTOArray
     * @return DTO Object Array
     * */
    public Object[] asDTOArray(){
        ArrayList <HumanBeingDTO> dtos = new ArrayList<>();
        col.forEach(hb -> dtos.add(new HumanBeingDTO(hb)));
        return dtos.toArray();
    }

    /**
     * asList
     * @return ArrayList of HumanBeing
     * */
    public ArrayList <HumanBeing> asList() {
        return col;
    }

    /**
     * clear collection
     * */
    public void clear(){
        col.clear();
    }

    /**
     * add
     * push back HumanBeing
     * */
    public void add(HumanBeing h){
        col.add(h);
    }

    /**
     * removeIf
     * removes HumanBeings by condition
     * */
    public void removeIf(Predicate <HumanBeing> condition){
        col.removeIf(condition);
    }

    /**
     * getSize
     * @return size of collection
     * */
    public int getSize(){
        return col.size();
    }

    /**
     * getType
     * @return String collection type
     * */
    public String getType(){
        return col.getClass().getSimpleName();
    }

    /**
     * getCreationDate
     * @return Date creationDate
     * */
    public Date getCreationDate(){
        return creationDate;
    }

    /**
     * hasId
     * Check if collection has HumanBeing with id
     * */
    public boolean hasId(Integer id){
        for(HumanBeing h : col){
            if(h.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public boolean removeById(Integer id){
        if(!hasId(id)){
            return false;
        }
        removeIf(h -> h.getId().equals(id));
        return true;
    }

    public boolean update(Integer id, HumanBeing humanBeing){
        if(!removeById(id)){
            return false;
        }
        humanBeing.setId(id);
        col.add(humanBeing);
        return true;
    }

    public void insertAt(int index, HumanBeing humanBeing){
        col.add(index, humanBeing);
    }

}