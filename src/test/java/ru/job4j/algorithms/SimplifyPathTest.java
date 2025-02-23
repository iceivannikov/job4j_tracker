package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplifyPathTest {

    @Test
    public void whenPathEndsWithSlash_thenRemoveTrailingSlash() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/home/");
        assertEquals("/home", result);
    }

    @Test
    public void whenPathHasMultipleSlashes_thenReplaceWithSingleSlash() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/home//foo/");
        assertEquals("/home/foo", result);
    }

    @Test
    public void whenPathHasParentDirectory_thenGoUpOneLevel() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/home/user/Documents/../Pictures");
        assertEquals("/home/user/Pictures", result);
    }

    @Test
    public void whenPathGoesAboveRoot_thenReturnRoot() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/../");
        assertEquals("/", result);
    }

    @Test
    public void whenPathHasCurrentDirectory_thenIgnoreIt() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/home/./user/./Documents");
        assertEquals("/home/user/Documents", result);
    }

    @Test
    public void whenPathHasValidDots_thenTreatAsDirectory() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/.../a/../b/c/../d/./");
        assertEquals("/.../b/d", result);
    }

    @Test
    public void whenPathIsRoot_thenReturnRoot() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/");
        assertEquals("/", result);
    }

    @Test
    public void whenPathIsEmpty_thenReturnRoot() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("");
        assertEquals("/", result);
    }

    @Test
    public void whenPathHasComplexStructure_thenSimplifyCorrectly() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/a/b/../../c/");
        assertEquals("/c", result);
    }
}