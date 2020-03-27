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
//        col = new ArrayList<>(Arrays.asList(arr_col));
        col = new ArrayList<>();
        for(HumanBeingDTO dto : arr_col){
            dto.validateFields();
            add(dto.toHumanBeing());
        }
    }

    public Object[] asArray(){
        return col.toArray();
    }
    public Object[] asDTOArray(){
        ArrayList <HumanBeingDTO> dtos = new ArrayList<>();
        col.forEach(hb -> dtos.add(new HumanBeingDTO(hb)));
        return dtos.toArray();
    }
    public ArrayList <HumanBeing> asList() {
        return col;
    }

    public void clear(){
        col.clear();
    }

    public void add(HumanBeing h){
        col.add(h);
    }

    public void removeIf(Predicate <HumanBeing> condition){
        col.removeIf(condition);
    }

    public int getSize(){
        return col.size();
    }

    public String getType(){
        return col.getClass().getSimpleName();
    }

    public Date getCreationDate(){
        return creationDate;
    }

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