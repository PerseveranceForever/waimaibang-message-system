package com.waimaibang.dao;

import com.waimaibang.model.Destination;
import com.waimaibang.model.DestinationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DestinationDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    long countByExample(DestinationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    int deleteByExample(DestinationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    int insert(Destination record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    int insertSelective(Destination record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    List<Destination> selectByExample(DestinationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    Destination selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Destination record, @Param("example") DestinationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Destination record, @Param("example") DestinationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Destination record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table destination
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Destination record);
}