package com.mis.education.Education.MIS.ajax;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import com.mis.education.Education.MIS.modules.role.modal.RolesModal;
import com.mis.education.Education.MIS.modules.states.StatesMaster;
import com.mis.education.Education.MIS.repositories.ProductThumbnails.ProductThumbnailsDatatableRepository;
import com.mis.education.Education.MIS.repositories.cart_items.CartItemRepository;
import com.mis.education.Education.MIS.repositories.customer_address.CustomerAddressRepository;
import com.mis.education.Education.MIS.repositories.roles.RolesRepository;
import com.mis.education.Education.MIS.repositories.state.StateRepository;
import com.mis.education.Education.MIS.repositories.user.UserRepository;
import com.mis.education.Education.MIS.repositories.wishlist.WishlistDatatableRepository;
import com.mis.education.Education.MIS.repositories.wishlist.WishlistDatatableRepositoryCustom;
import com.mis.education.Education.MIS.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class AjaxContoller {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    ProductThumbnailsDatatableRepository productThumbnailsDatatableRepository;

    @Autowired
    WishlistDatatableRepository wishlistDatatableRepository;

    @Autowired
    CustomerAddressRepository customerAddressRepository;

    private static final Logger logger = LoggerFactory.getLogger(AjaxContoller.class);



    @RequestMapping(value = "/ajax/getStates", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    String getStates() throws Exception {
        Map<String, Object> map = null;
        List<StatesMaster> states = stateRepository.getAllStates();

        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, states);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);

        return jsonStr;

    }


    @RequestMapping(value = "/ajax/getRoles", method = RequestMethod.GET,  produces="application/json")
    public @ResponseBody
    String getRoles() throws JsonProcessingException {
        Map<String, Object> map = null;
        List<RolesModal> roles = rolesRepository.getRoles();


        map = new HashMap<String, Object>();
        map.put(Constants.keyResponse, roles);
        map.put(Constants.keyMessage, Constants.valueMessage);
        map.put(Constants.keyStatus, HttpStatus.OK);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        jsonStr = Obj.writeValueAsString(map);
        logger.info(jsonStr);
        return jsonStr;

    }


    @DeleteMapping("/ajax/deleteThumbnail/{id}")
    public ResponseEntity<?> deleteThumbnail(@PathVariable Integer id) throws JsonProcessingException {
        productThumbnailsDatatableRepository.deleteRow(id);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/ajax/deleteProductFromCart/{id}")
    public ResponseEntity<?> deleteProductFromCart(@PathVariable Integer id) throws JsonProcessingException {
        wishlistDatatableRepository.deleteRow(id);
        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/ajax/deleteUserAddress/{id}")
    public ResponseEntity<?> deleteUserAddress(@PathVariable Integer id) throws JsonProcessingException {
        customerAddressRepository.deleteRow(id);
        return ResponseEntity.ok().build();
    }
}
