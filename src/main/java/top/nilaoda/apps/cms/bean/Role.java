package top.nilaoda.apps.cms.bean;

public class Role {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_role.id
     *
     * @mbg.generated Thu Dec 19 17:23:47 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_role.name
     *
     * @mbg.generated Thu Dec 19 17:23:47 CST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_role.id
     *
     * @return the value of base_role.id
     *
     * @mbg.generated Thu Dec 19 17:23:47 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_role.id
     *
     * @param id the value for base_role.id
     *
     * @mbg.generated Thu Dec 19 17:23:47 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_role.name
     *
     * @return the value of base_role.name
     *
     * @mbg.generated Thu Dec 19 17:23:47 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_role.name
     *
     * @param name the value for base_role.name
     *
     * @mbg.generated Thu Dec 19 17:23:47 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}