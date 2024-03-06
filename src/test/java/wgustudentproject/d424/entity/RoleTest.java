package wgustudentproject.d424.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    public void testRoleInitialization() {
        Role role = new Role();
        assertEquals(0, role.getId());
        assertNull(role.getName());
    }

    @Test
    public void testRoleWithArguments() {
        long roleId = 1L;
        String roleName = "ADMIN";
        Role role = new Role(roleId, roleName);

        assertEquals(roleId, role.getId());
        assertEquals(roleName, role.getName());
    }

    @Test
    public void testRoleSetName() {
        Role role = new Role();
        String roleName = "USER";
        role.setName(roleName);

        assertEquals(roleName, role.getName());
    }

}